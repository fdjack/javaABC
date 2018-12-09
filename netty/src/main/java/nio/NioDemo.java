package nio;

import org.junit.Test;

import java.math.BigDecimal;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

/**
 * @author: zhangyi
 * @date: 2018/12/7 15:49
 * @description:
 */
public class NioDemo {


    private Integer port = 29810;

    /**
     * 服务器端
     *
     */
    @Test
    public void server() throws Exception {
        long startTime = System.currentTimeMillis();
        FileChannel open = FileChannel
                .open(Paths
                        .get("E:\\JAVAWEB\\nio+juc\\nio\\source\\create.text"),
                        StandardOpenOption.WRITE,
                        StandardOpenOption.CREATE);
        ServerSocketChannel sk = ServerSocketChannel.open();
        //绑定连接
        sk.bind(new InetSocketAddress(port));
        System.out.println("服务器端开启...等待客户端传输数据");
        //获取客户端的连接通道
        SocketChannel accept = sk.accept();
        //分配缓冲区大小
        ByteBuffer allocate = ByteBuffer.allocate(1024);
        //写入数据 查看文件进度
        while(accept.read(allocate) != -1){
            allocate.flip();
            open.write(allocate);
            allocate.clear();
            BigDecimal bigDecimal = BigDecimal.valueOf(open.position() / (open.size()*1.0));
            BigDecimal bigDecimal1 = bigDecimal.setScale(2, BigDecimal.ROUND_DOWN);
            System.out.println(bigDecimal1.multiply(BigDecimal.valueOf(100)));
        }
        System.out.println("文件传输完毕,所用时间："+(System.currentTimeMillis()-startTime));
        open.close();
        sk.close();
        accept.close();
    }

    /**
     * 客户端
     *
     * @throws Exception
     */
    @Test
    public void cilent() throws Exception {
        //绑定地址和端口
        SocketChannel sc = SocketChannel.open(new InetSocketAddress("127.0.0.1",port));
        FileChannel fileChannel =
                FileChannel.open(Paths.get("E:\\JAVAWEB\\nio+juc\\nio\\source\\1.pdf")
                        ,StandardOpenOption.READ);
        System.out.println("客户端发送数据");
        ByteBuffer buf = ByteBuffer.allocate(1024);

        //读取本地文件，发送服务器,将数据写入缓冲区
        while(fileChannel.read(buf) != -1){
            buf.flip();
            sc.write(buf);
            buf.clear();
        }
        System.out.println("客户端数据发送成功");
        sc.close();
        fileChannel.close();
    }

}
