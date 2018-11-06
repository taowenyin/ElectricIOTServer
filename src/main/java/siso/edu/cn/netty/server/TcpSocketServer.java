package siso.edu.cn.netty.server;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.net.InetSocketAddress;

@Component
public class TcpSocketServer {

    private ServerBootstrap bootstrap;
    private InetSocketAddress tcpPort;

    private ChannelFuture channelFuture;

    @Autowired
    public TcpSocketServer(ServerBootstrap bootstrap, InetSocketAddress tcpPort) {
        this.bootstrap = bootstrap;
        this.tcpPort = tcpPort;
    }

    @PostConstruct
    public void start() throws InterruptedException {
        System.out.println("Starting server at " + tcpPort);
        channelFuture = bootstrap.bind(tcpPort).sync();
    }

    @PreDestroy
    public void stop() throws InterruptedException {
        channelFuture.channel().closeFuture().sync();
    }

    public ServerBootstrap getBootstrap() {
        return bootstrap;
    }

    public void setBootstrap(ServerBootstrap bootstrap) {
        this.bootstrap = bootstrap;
    }

    public InetSocketAddress getTcpPort() {
        return tcpPort;
    }

    public void setTcpPort(InetSocketAddress tcpPort) {
        this.tcpPort = tcpPort;
    }
}
