package netty.discard;

import io.netty.bootstrap.Bootstrap;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;

import java.io.UnsupportedEncodingException;
import java.util.Objects;
import java.util.Scanner;

/**
 * 客户端请求
 *
 * @author: zhangyi
 * @date: 2018/12/5 21:13
 * @description:
 */
public class ClientDemo {
    public static void main(String[] args) {
        NioEventLoopGroup clientGroup = null;
        try {
            clientGroup = new NioEventLoopGroup();
            Bootstrap bootstrap = new Bootstrap();
            ChannelFuture connect = bootstrap.group(clientGroup)
                    .channel(NioSocketChannel.class)
                    .handler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel ch) throws Exception {
                            ch.pipeline().addLast(new ClientHandler());
                        }
                    })
                    .connect("localhost", 10980);
            while (true) {
                Scanner scanner = new Scanner(System.in);
                System.out.println("输入 exit 结束：");
                String s = scanner.nextLine();

                if (!Objects.isNull(s) && s.equals("exit")) {
                    connect.channel()
                            .writeAndFlush(Unpooled.copiedBuffer(s.getBytes("UTF-8")))
//                            关闭监听器，代表ChannelFuture执行返回后，关闭连接。
                            .addListener(ChannelFutureListener.CLOSE);
                    break;
                }
                connect.channel().writeAndFlush(Unpooled
                                        .copiedBuffer(s.getBytes("UTF-8")));
            }
        }catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } finally {
            clientGroup.shutdownGracefully();
        }
    }
}
