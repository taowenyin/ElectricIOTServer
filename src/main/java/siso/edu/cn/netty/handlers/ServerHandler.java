package siso.edu.cn.netty.handlers;

import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.net.InetAddress;

@Component
@ChannelHandler.Sharable
public class ServerHandler extends SimpleChannelInboundHandler<String> {

    private static final Logger LOGGER = LoggerFactory.getLogger(ServerHandler.class);

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, String msg) throws Exception {
        LOGGER.info("Client Msg: " + msg);

        String clientIdToLong = ctx.channel().id().asLongText();
        LOGGER.info("Client Long ID: " + clientIdToLong);

        String clientIdToShort= ctx.channel().id().asShortText();
        LOGGER.info("Client Short ID: " + clientIdToLong);

        if(msg.contains("bye")) {
            ctx.channel().close();
        } else {
            ctx.channel().writeAndFlush("Your msg is: " + msg);
        }
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        super.channelActive(ctx);

        LOGGER.info("Remote Address : " + ctx.channel().remoteAddress() + " active !");

        ctx.channel().writeAndFlush( "Welcome to " + InetAddress.getLocalHost().getHostName() + " service!\n");
    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        super.channelInactive(ctx);

        // 通道断开
        LOGGER.info(ctx.channel().id() + " Channel is disconnected");
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        super.exceptionCaught(ctx, cause);

        cause.printStackTrace(); // 捕获异常并关闭通道
        ctx.close();
    }
}
