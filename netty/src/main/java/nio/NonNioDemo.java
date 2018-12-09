package nio;

import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.Scanner;

/**
 * @author: zhangyi
 * @date: 2018/12/7 17:00
 * @description:
 */
public class NonNioDemo {

    private Integer port;

    @Before
    public void initPort(){
        port = 8907;
    }

    @Test
    public void server() throws Exception{
        //建立通道
        ServerSocketChannel sc = ServerSocketChannel.open();
        //切换到非阻塞IO上去
        sc.configureBlocking(false);
        //绑定端口
        sc.bind(new InetSocketAddress(port));
        //创建selector选择器
        Selector open = Selector.open();
        //注册通道，指定监听其事件
        sc.register(open,SelectionKey.OP_ACCEPT);
        while(open.select() > 0) {
            Iterator<SelectionKey> iterator = open.selectedKeys().iterator();
            while (iterator.hasNext()){
                //获取准备就绪的事件类型
                SelectionKey next = iterator.next();
                if(next.isAcceptable()){
                    // 若“接收就绪”，获取客户端连接
                    SocketChannel accept = sc.accept();
                    //切换非阻塞模式
                    accept.configureBlocking(false);
                    //注册通道
                    accept.register(open,SelectionKey.OP_READ);
                }else if(next.isReadable()){
                    //获取当前选择器上“读就绪”状态的通道
                    SocketChannel channel = (SocketChannel) next.channel();
                    //设置缓冲
                    ByteBuffer allocate = ByteBuffer.allocate(1024);
                    int len = 0;
                    while((len = channel.read(allocate)) != -1){
                        allocate.flip();
                        System.out.println(new String(allocate.array(),0,len));
                        allocate.clear();
                    }
                }
                //取消选择键 SelectionKey
                iterator.remove();
            }
        }
    }

    @Test
    public void client() throws IOException {
        //获取通道
        SocketChannel socketChannel =
                SocketChannel.open(
                        new InetSocketAddress("127.0.0.1",port));
        //切换成非阻塞
        socketChannel.configureBlocking(false);

        //分配缓冲区
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
        Scanner scanner = new Scanner(System.in);

        while(scanner.hasNext()){
            String next = scanner.next();
            if(next.equals("exit")){
                break;
            }
            byteBuffer.put(next.getBytes(Charset.forName("UTF-8")));
            byteBuffer.flip();
            socketChannel.write(byteBuffer);
            byteBuffer.clear();
        }
        socketChannel.close();
    }

}
/**
 * 创建两个NioEventLoopGroup,这两个对象可以看做是传统IO编程模型的两大线程组,boosGroup表示监听端口,创建新连接的线程组,workerGroup表示处理每一条连接的数据读写的线程组
 * 创建引导类 ServerBootstrap进行服务端的启动工作,通过.group(boosGroup, workerGroup)给引导类配置两大线程定型引导类的线程模型指定服务端的IO模型为NIO,通过.channel(NioServerSocketChannel.class)来指定IO模型
 * 调用childHandler()方法给引导类创建ChannelInitializer定义后续每条连接的数据读写,业务处理逻辑,泛型参数NioSocketChannel是Netty对NIO类型的连接的抽象,而NioServerSocketChannel也是对NIO类型的连接的抽象
 * serverBootstrap.bind()是异步的方法调用之后是立即返回的,返回值是ChannelFuture,给ChannelFuture添加监听器GenericFutureListener,在GenericFutureListener的operationComplete方法里面监听端口是否绑定成功
 * childHandler()用于指定处理新连接数据的读写处理逻辑,handler()用于指定在服务端启动过程中的一些逻辑
 * attr()方法给服务端的channel即NioServerSocketChannel指定一些自定义属性,通过channel.attr()取出该属性,给NioServerSocketChannel维护一个map
 * childAttr()方法给每一条连接指定自定义属性,通过channel.attr()取出该属性
 * childOption()方法给每条连接设置一些TCP底层相关的属性:
 * ChannelOption.SO_KEEPALIVE表示是否开启TCP底层心跳机制,true为开启
 * ChannelOption.SO_REUSEADDR表示端口释放后立即就可以被再次使用,因为一般来说,一个端口释放后会等待两分钟之后才能再被使用
 * ChannelOption.TCP_NODELAY表示是否开始Nagle算法,true表示关闭,false表示开启,通俗地说,如果要求高实时性,有数据发送时就马上发送,就关闭,如果需要减少发送次数减少网络交互就开启
 * option()方法给服务端channel设置一些TCP底层相关的属性:
 * ChannelOption.SO_BACKLOG表示系统用于临时存放已完成三次握手的请求的队列的最大长度,如果连接建立频繁,服务器处理创建新连接较慢,适当调大该参数
 *
 * @param args
 */