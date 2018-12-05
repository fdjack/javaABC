package netty;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelPromise;

import java.nio.charset.Charset;

/**
 * @author: zhangyi
 * @date: 2018/12/4 23:09
 * @description:
 */
public class ServerHandler extends ChannelHandlerAdapter {
    /**
     *
     *
     * @param ctx
     * @param cause
     * @throws Exception
     */
    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        System.out.println("远程连接关闭");
        ctx.close();
        cause.printStackTrace();
    }

    /**
     * ctx
     *
     * @param ctx
     * @param msg
     * @throws Exception
     */
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        ByteBuf readBuffer = (ByteBuf) msg;
        byte[] buf = new byte[readBuffer.readableBytes()];
        readBuffer.readBytes(buf);
        String str = new String(buf, Charset.forName("UTF-8"));
        System.out.println("服务器发送的消息"+str);
        if(str.equals("exit")){
            ctx.close();
            return;
        }
        String write = "返回客户端信息"+str;
        //释放缓存，方式内存溢出
        ctx.writeAndFlush(
                Unpooled.copiedBuffer(write.getBytes("UTF-8")));
    }

    @Override
    public void disconnect(ChannelHandlerContext ctx, ChannelPromise promise) throws Exception {
        super.disconnect(ctx, promise);
    }
}
