package com.game.main;

import com.game.myconst.ConstHelper;
import com.game.proto.LoginMessage;
import java.net.InetSocketAddress;
import java.util.Scanner;
import org.apache.mina.core.filterchain.DefaultIoFilterChainBuilder;
import org.apache.mina.core.filterchain.IoFilter;
import org.apache.mina.core.future.ConnectFuture;
import org.apache.mina.core.service.IoConnector;
import org.apache.mina.core.service.IoHandler;
import org.apache.mina.core.session.IdleStatus;
import org.apache.mina.core.session.IoSession;
import org.apache.mina.core.session.IoSessionConfig;
import org.apache.mina.filter.codec.ProtocolCodecFilter;
import org.apache.mina.transport.socket.nio.NioSocketConnector;

/**
 *
 * @author Vicky
 */
public class MainClient {

    public static void main(String[] args) {
        final IoConnector connector = new NioSocketConnector();

        // 2.
        IoSessionConfig sessionConfig = connector.getSessionConfig();
        sessionConfig.setReaderIdleTime(300);
        sessionConfig.setReadBufferSize(1024 * 2);

        // 3
        DefaultIoFilterChainBuilder filterChain = connector.getFilterChain();
        IoFilter filter = new ProtocolCodecFilter(new ServerProtocolCodecFactory());
        filterChain.addLast("codec", filter);

        // 5
        connector.setHandler(new IoHandler() {
            @Override
            public void sessionCreated(IoSession session) throws Exception {
                ConstHelper.AddLoggerInfo("创建一个会话链接（未连接）");
            }

            @Override
            public void sessionOpened(IoSession session) throws Exception {
                ConstHelper.AddLoggerInfo("服务器与客户端会建立连接");
            }

            @Override
            public void sessionClosed(IoSession session) throws Exception {
                ConstHelper.AddLoggerInfo("服务器与客户端会话链接已经关闭");
            }

            @Override
            public void sessionIdle(IoSession session, IdleStatus status) throws Exception {
                ConstHelper.AddLoggerInfo("客户端端进入空闲状态");
                //session.close(false);
            }

            @Override
            public void exceptionCaught(IoSession session, Throwable cause) throws Exception {
                ConstHelper.AddLoggerInfo("Error:客户端捕获到异常"+ cause);
                session.close(true);
            }

            @Override
            public void messageReceived(IoSession session, Object message) throws Exception {
                ConstHelper.AddLoggerInfo("接收到服务器端消息:" + message);
            }

            /**
             * 注意这里是消息发送后回调，非发送消息！！！
             */
            @Override
            public void messageSent(IoSession session, Object message) throws Exception {
                // 发送返回消息后就断开与客户端的链接，这就类似HTTP请求一样的短链接模式
                // session.close(true)
            }
        });

        // 6
        ConnectFuture connectFuture = connector.connect(new InetSocketAddress("127.0.0.1", 9527));

        // 7
        // 异步等待，实现同步效果方案一：阻塞主线程
        connectFuture.awaitUninterruptibly();
        IoSession session = connectFuture.getSession();
        Scanner scanner = new Scanner(System.in);
        String msg = scanner.nextLine();
        while (!msg.equalsIgnoreCase("exit")) {
            LoginMessage.ReqLoginMessage reqLoginMessage = null;
            {
                LoginMessage.ReqLoginMessage.Builder newBuilder = LoginMessage.ReqLoginMessage.newBuilder();
//                newBuilder.setSendFrom(1L);
//                newBuilder.addSendTo(1L);
//                newBuilder.addSendTo(2L);
//                newBuilder.addSendTo(3L);
                newBuilder.setUsername(msg);
                newBuilder.setPassword("123456");
                reqLoginMessage = newBuilder.build();
            }
            if (reqLoginMessage != null) session.write(reqLoginMessage);
            msg = scanner.nextLine();
        }

        // 异步等待，实现同步效果方案二
//        connectFuture.addListener(new IoFutureListener<ConnectFuture>() {
//
//            @Override
//            public void operationComplete(ConnectFuture future) {
//                try {
//                    Thread.sleep(5000);
//                } catch (java.lang.InterruptedException e) {
//                }
//                System.out.println("++++++++++++++++++");
//                IoSession session = future.getSession();
//            }
//        });
//
//        System.out.println("****************");
    }
}
