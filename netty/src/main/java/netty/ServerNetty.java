package netty;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;

/**
 * @author: zhangyi
 * @date: 2018/12/4 22:58
 * @description:
 */
public class ServerNetty {

    private EventLoopGroup boos= null;

    private  EventLoopGroup worker = null;

    private ServerBootstrap s = null;

    public ServerNetty() {
        init();
    }

    public  void init(){
        //监测客户端连接的线程
        boos = new NioEventLoopGroup();
        //处理客户端链接的线程
        worker = new NioEventLoopGroup();

        s = new ServerBootstrap();

        s.group(boos,worker)
                .channel(NioServerSocketChannel.class)
                //设置缓冲区大小
                .option(ChannelOption.SO_BACKLOG,1024)
                //发送缓冲区大小
                .option(ChannelOption.SO_RCVBUF,16*1024)
                //心跳检测
                .option(ChannelOption.SO_KEEPALIVE,true)
//                绑定端口
                .localAddress(10980);
    }

    public ChannelFuture server() throws InterruptedException {
        //ChannelInitializer-->
        s.childHandler(new ChannelInitializer<SocketChannel>() {
            /**
             *
             * @param ch
             * @throws Exception
             */
            @Override
            protected void initChannel(SocketChannel ch) throws Exception {
                ch.pipeline().addLast(new ServerHandler());
            }
        });
        //sync --> 启动
        ChannelFuture future = s.bind().sync();
        return future;
    }

    public void release(){
        boos.shutdownGracefully();
        worker.shutdownGracefully();
    }


    public static void main(String[] args) throws InterruptedException {
            ServerNetty serverNetty = new ServerNetty();
        ChannelFuture server = serverNetty.server();
        System.out.println("服务器启动");

        server.channel().closeFuture().sync();
    }
}
