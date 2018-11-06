package siso.edu.cn.config;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelOption;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import siso.edu.cn.netty.handlers.ServerHandler;
import siso.edu.cn.netty.handlers.StringProtocolInitalizer;

import java.net.InetSocketAddress;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@Configuration
@ComponentScan(basePackages = {"siso.edu.cn.netty"})
public class NettyConfig {

    private final static int BOSS_COUNT = 2; // Netty启动后使用的进程数
    private final static int WORKER_COUNT = 2; // Netty每个进程所使用的线程
    private final static int TCP_PORT = 8090; // TCP接入的端口号
    private final static boolean KEEP_ALIVE = true; // 不主动断开，保持连接
    private final static int BACK_LOG= 100; // TCP连接队列的大小

//    // 配置字符串协议
//    @Autowired
//    @Qualifier("springProtocolInitializer")
//    private StringProtocolInitalizer protocolInitalizer;

//    @Autowired
//    public NettyConfig(StringProtocolInitalizer protocolInitalizer) {
//        this.protocolInitalizer = protocolInitalizer;
//    }

    /**
     * 初始化服务器字符串协议
     * @param decoder 编码器
     * @param encoder 解码器
     * @param serverHandler 服务处理器
     * @return 协议对象
     */
    @Bean
    public StringProtocolInitalizer protocolInitalizer(StringDecoder decoder, StringEncoder encoder, ServerHandler serverHandler) {
        return new StringProtocolInitalizer(decoder, encoder, serverHandler);
    }

    @Bean
    public ServerHandler serverHandler() {
        return new ServerHandler();
    }

    /**
     * 初始化服务器引导对象
     * @return 服务器引导对象
     */
    @Bean
    public ServerBootstrap serverBootstrap(StringProtocolInitalizer protocolInitalizer) {
        ServerBootstrap bootstrap = new ServerBootstrap();

        bootstrap.group(bossGroup(), workerGroup()) // 设置进程和线程的大小
                .channel(NioServerSocketChannel.class)
                .option(ChannelOption.SO_KEEPALIVE, KEEP_ALIVE)
                .option(ChannelOption.SO_BACKLOG, BACK_LOG)
                .childHandler(protocolInitalizer); // 设置TCP协议处理对象

        return bootstrap;
    }

    @Bean(destroyMethod = "shutdownGracefully")
    public NioEventLoopGroup bossGroup() {
        return new NioEventLoopGroup(BOSS_COUNT);
    }

    @Bean(destroyMethod = "shutdownGracefully")
    public NioEventLoopGroup workerGroup() {
        return new NioEventLoopGroup(WORKER_COUNT);
    }

    @Bean
    public InetSocketAddress tcpPort() {
        return new InetSocketAddress(TCP_PORT);
    }

    @Bean
    public StringEncoder stringEncoder() {
        return new StringEncoder();
    }

    @Bean
    public StringDecoder stringDecoder() {
        return new StringDecoder();
    }
}

