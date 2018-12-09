package netty.discard;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;
import io.netty.util.CharsetUtil;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author: zhangyi
 * @date: 2018/12/5 20:57
 * @description:
 */
public class DiscardHandler extends ChannelHandlerAdapter {

    private AtomicInteger count;

    public DiscardHandler(AtomicInteger count) {
        this.count = count;
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        System.out.println("客户端断开连接");
        ctx.writeAndFlush(Unpooled.copiedBuffer("有一个客户端断开连接".getBytes("UTF-8")));
        count.decrementAndGet();
//        cause.printStackTrace();

    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        ByteBuf msg1 = (ByteBuf) msg;
        byte[] buf = new byte[msg1.readableBytes()];
        msg1.readBytes(buf);
        String s = new String(buf, "UTF-8");
        System.out.println("客户端发来的信息："+s);
        // 写操作自动释放缓存，避免内存溢出问题。
        ctx.writeAndFlush(Unpooled.copiedBuffer(("服务器已经接收到数据: "+s).getBytes("UTF-8")));
//        //丢弃信息
//        ReferenceCountUtil.release(msg);
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        String clients = "当前连接数：" + count.incrementAndGet();
        ctx.writeAndFlush(Unpooled.copiedBuffer(clients,CharsetUtil.UTF_8));
    }
}
