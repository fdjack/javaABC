package netty;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;

/**
 * @author: zhangyi
 * @date: 2018/12/4 22:58
 * @description:
 */
public class ClientNetty {

    private EventLoopGroup worker = null;

    private Bootstrap s = null;

    public ClientNetty() {
        init();
    }

    public void init(){
        worker = new NioEventLoopGroup();
        s = new Bootstrap();
        s.group(worker)
        .channel(NioSocketChannel.class);
    }

    public void release(){
        worker.shutdownGracefully();
    }


    public ChannelFuture client() throws InterruptedException {
        s.handler(new ChannelInitializer<SocketChannel>() {
            @Override
            protected void initChannel(SocketChannel ch) throws Exception {
                ch.pipeline().addLast(new ClientHandler());
            }
        });
        ChannelFuture connect = s.connect("localhost", 10980).sync();
        return  connect;
    }

    public static void main(String[] args) throws InterruptedException {
        ClientNetty clientNetty = new ClientNetty();
        ChannelFuture client = clientNetty.client().sync();
        client.channel().closeFuture().sync();
    }
}
