/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fly.com.object_engine.nio.mina;

import java.io.IOException;
import java.net.InetSocketAddress;
import org.apache.log4j.Logger;
import org.apache.mina.core.filterchain.DefaultIoFilterChainBuilder;
import org.apache.mina.core.filterchain.IoFilter;
import org.apache.mina.core.service.IoAcceptor;
import org.apache.mina.core.session.IdleStatus;
import org.apache.mina.filter.codec.ProtocolCodecFilter;
import org.apache.mina.transport.socket.nio.NioSocketAcceptor;

/**
 *
 * @author Administrator
 */
public class MinaTcpServer {

    IoAcceptor _acceptor;
    private static final Logger logger = Logger.getLogger(MinaTcpServer.class);

    public MinaTcpServer() {
        //创建一个nio异步的socket监听服务器
        _acceptor = new NioSocketAcceptor();
        ///设置缓冲区大小，
        _acceptor.getSessionConfig().setReadBufferSize(1024 * 5);
        ///设置进入空闲状态时间，秒为单位
        _acceptor.getSessionConfig().setIdleTime(IdleStatus.BOTH_IDLE, 10);
        ///编解码器
        DefaultIoFilterChainBuilder filterChain = _acceptor.getFilterChain();
        IoFilter filter = new ProtocolCodecFilter(new BufferMarshalFactory());
        filterChain.addLast("codec", filter);
        ///添加实现类，客户端连接，断开，消息处理等
        _acceptor.setHandler(new MinaIOHandler());
    }

    /**
     * 启动 socket 监听
     *
     * @param port 监听端口号
     * @return 是否启动成功
     */
    public boolean Start(int port) {
        try {
            ///绑定一个监听端口号
            _acceptor.bind(new InetSocketAddress(port));
            logger.info("开启端口为 " + port + " 监听服务");
            return true;
        } catch (IOException ex) {
            logger.error("监听端口 " + port + " 失败 Exception：" + ex);
            return false;
        }
    }

    /**
     * 释放Nio资源
     */
    public void Dispose() {
        _acceptor.dispose();
    }
}
