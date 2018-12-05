package netty.simple_nio_server;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.util.CharsetUtil;

/**
 * @author: zhangyi
 * @date: 2018/11/19 22:40
 * @description:
 */
public class EchoClientHandle extends SimpleChannelInboundHandler<ByteBuf> {

    protected void messageReceived(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf) throws Exception {

    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        ByteBuf byteM = (ByteBuf) msg;
        System.out.println("服务端发送的数据"+byteM.toString(CharsetUtil.UTF_8));
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
       ctx.writeAndFlush(Unpooled.copiedBuffer("--客户端数据",CharsetUtil.UTF_8));
    }
}
