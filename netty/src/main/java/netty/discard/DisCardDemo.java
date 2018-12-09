package netty.discard;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author: zhangyi
 * @date: 2018/12/5 12:00
 * @description:
 */
public class DisCardDemo {
    private static AtomicInteger currentClients = null;
    static {
        /**
         * 客户端数量
         */
        currentClients = new AtomicInteger(0);
    }
    public static void main(String[] args) {
        //检测客户端连接 ，注册到worker上
        EventLoopGroup boos = new NioEventLoopGroup();

        EventLoopGroup worker = new NioEventLoopGroup();

        ServerBootstrap serverBootstrap = new ServerBootstrap();
        ChannelFuture sync = null;
        try {
            ServerBootstrap boot = serverBootstrap.group(boos, worker)
                    .channel(NioServerSocketChannel.class)
                    .childHandler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel ch) throws Exception {
                            ch.pipeline().addLast(new DiscardHandler(currentClients));
                        }
                    });
            //绑定端口，接受连接
            sync = boot.bind(10980).sync();
//            System.out.println("丢弃服务器启动...");
            System.out.println("应答服务器...");
            //等待服务器关闭
            sync.channel().closeFuture().sync();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally{
            if(null != sync){
                try {
                    sync.channel().closeFuture().sync();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            boos.shutdownGracefully();
            worker.shutdownGracefully();
        }
    }
}
