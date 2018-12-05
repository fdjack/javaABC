package netty.simple_nio_server;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;

/**
 * @author: zhangyi
 * @date: 2018/11/19 22:30
 * @description:
 */
public class EchoServer {

    private final Integer port;

    public EchoServer(Integer port){
        this.port = port;
    }

    public static void main(String[] args) throws Exception{
        new EchoServer(10890).start();
    }

    public void start() throws Exception{
        EventLoopGroup nioEventLoopGroup = new NioEventLoopGroup();
        ServerBootstrap serverBootstrap = new ServerBootstrap();
        serverBootstrap.group(nioEventLoopGroup)
                .channel(NioServerSocketChannel.class)
                .localAddress(port)
                .childHandler(new ChannelInitializer<SocketChannel>() {
                    //��ʵ����Channel��ChannelPipeline�У��������վ��Ϣ��֪ͨ��EchoSerHandle��
                    protected void initChannel(SocketChannel socketChannel) throws Exception {
                        socketChannel.pipeline().addLast(new EchoServerHandle());
                    }
                });
        ChannelFuture sync = serverBootstrap.bind().sync();

        System.out.println(EchoServer.class.getName()+"--"+sync.channel().localAddress());

        sync.channel().closeFuture().sync();
        nioEventLoopGroup.shutdownGracefully().sync();
    }
}
