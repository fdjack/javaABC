package netty.simple_nio_server;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;

import java.net.InetSocketAddress;

/**
 * @author: zhangyi
 * @date: 2018/11/19 22:58
 * @description:
 */
public class EchoClient {

    private final String host;

    private final Integer port;

    public EchoClient(String host, Integer port) {
        this.host = host;
        this.port = port;
    }

    public void start()throws Exception{
        EventLoopGroup eventLoopGroup = new NioEventLoopGroup();
        Bootstrap bootstrap = new Bootstrap();
        bootstrap.group(eventLoopGroup)
                .channel(NioSocketChannel.class)
                .remoteAddress(new InetSocketAddress(host,port))
                .handler(new ChannelInitializer<SocketChannel>() {
                    protected void initChannel(SocketChannel socketChannel) throws Exception {
                        socketChannel.pipeline().addLast(new EchoClientHandle());
                    }
                });
        ChannelFuture sync = bootstrap.connect().sync();

        sync.channel().closeFuture().sync();

        eventLoopGroup.shutdownGracefully().sync();
    }

    public static void main(String[] args) throws Exception {
        new EchoClient("127.0.0.1",10890).start();
    }
}
