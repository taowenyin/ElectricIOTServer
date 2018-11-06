package siso.edu.cn.netty.handlers;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("springProtocolInitializer")
public class StringProtocolInitalizer extends ChannelInitializer<SocketChannel> {

    private StringDecoder decoder;
    private StringEncoder encoder;
    private ServerHandler serverHandler;

    private final static String DECODER_KEY = "decoder";
    private final static String ENCODER_KEY = "encoder";
    private final static String HANDLER_KEY = "handler";

    @Autowired
    public StringProtocolInitalizer(StringDecoder decoder, StringEncoder encoder, ServerHandler serverHandler) {
        this.decoder = decoder;
        this.encoder = encoder;
        this.serverHandler = serverHandler;
    }

    @Override
    protected void initChannel(SocketChannel ch) throws Exception {
        ChannelPipeline pipeline = ch.pipeline();
        pipeline.addLast(DECODER_KEY, decoder);
        pipeline.addLast(ENCODER_KEY, encoder);
        pipeline.addLast(HANDLER_KEY, serverHandler);
    }

    public StringDecoder getDecoder() {
        return decoder;
    }

    public void setDecoder(StringDecoder decoder) {
        this.decoder = decoder;
    }

    public StringEncoder getEncoder() {
        return encoder;
    }

    public void setEncoder(StringEncoder encoder) {
        this.encoder = encoder;
    }

    public ServerHandler getServerHandler() {
        return serverHandler;
    }

    public void setServerHandler(ServerHandler serverHandler) {
        this.serverHandler = serverHandler;
    }
}
