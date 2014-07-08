package com.game.main;

import com.game.myconst.ConstHelper;
import com.game.proto.LoginMessage;
import com.game.proto.UserVersionMessage;
import com.google.protobuf.Descriptors;
import com.google.protobuf.Message;
import java.net.InetSocketAddress;
import org.apache.mina.core.buffer.IoBuffer;
import org.apache.mina.core.filterchain.DefaultIoFilterChainBuilder;
import org.apache.mina.core.filterchain.IoFilter;
import org.apache.mina.core.service.IoAcceptor;
import org.apache.mina.core.service.IoHandler;
import org.apache.mina.core.session.IdleStatus;
import org.apache.mina.core.session.IoSession;
import org.apache.mina.filter.codec.ProtocolCodecFactory;
import org.apache.mina.filter.codec.ProtocolCodecFilter;
import org.apache.mina.filter.codec.ProtocolDecoder;
import org.apache.mina.filter.codec.ProtocolEncoder;
import org.apache.mina.filter.logging.LoggingFilter;
import org.apache.mina.transport.socket.nio.NioSocketAcceptor;

/**
 *
 * @author Administrator
 */
public class MainServer {

    private static final int PORT = 9527;

    public static void main(String[] args) throws Exception {

        // 1.不论是服务器端还是客户端,首先想到的是IoService
        // 2.我们现在编写的是服务器端,那么应该想到的是IoService的子类,IoAcceptor
        // 同Servlet技术一样,web.xml中首先添加的是监听器,在创建不同的IoService对象时,
        //      将伴随创建对应的IoServiceListener
        final IoAcceptor acceptor = new NioSocketAcceptor(); // 创建非阻塞式的acceptor

        // 3.IoService主要是管理Session(会话),那么我们可以通过IoSessionConfig配置该服务层管辖的Session配置
        // IoSessionConfig sessionConfig = acceptor.getSessionConfig();
        // sessionConfig.setReaderIdleTime(3);
        // sessionConfig.setReadBufferSize(1024 * 2);
        // 4.在配置了IoService有关Session的基础配置后,我们需要考略,处理这些Session的过滤器,原理同Servlet中的Filter,
        //      如通过Filter来处理编码格式
        DefaultIoFilterChainBuilder filterChain = acceptor.getFilterChain();
        IoFilter filter = new ProtocolCodecFilter(new ServerProtocolCodecFactory());
        filterChain.addLast("codec", filter);

        addLogger(filterChain);

        // 5.IoService创建后(伴随IoServiceListener的生产),编写管辖的Session的SessionConfig,以及处理Session
        //      的过滤链FilterChain后,我们还需要一个及业务逻辑层,也就是IoHandler,这就好比真实的Servlet对象
        //      IoHandler包含的函数,就相当于Servlet中的doGet()及doPost()一样,
        //      不同的是我们仅仅需要一个IoHandler就行了,而不必如多个Servelt进行不同处理,因为Servlet是通过
        //      url地址(如http://127.0.0.1/servlet/login)来区分具体的处理规则,而IoHandler则是通过协议来区分处理规则
        acceptor.setHandler(new ChatProtocolHandler());
        acceptor.bind(new InetSocketAddress(PORT));

        ConstHelper.AddLoggerInfo("Listening on port " + PORT);
    }

    private static void addLogger(DefaultIoFilterChainBuilder chain) throws Exception {
        chain.addLast("logger", new LoggingFilter());
        ConstHelper.AddLoggerInfo("Logging ON");
    }

}

class ServerContext {

    private final IoBuffer buff;

    public ServerContext() {
        this.buff = IoBuffer.allocate(256);
        this.buff.setAutoExpand(true); // 允许自动扩展容量
        this.buff.setAutoShrink(true); // 允许自动缩减容量
    }

    public void append(IoBuffer buff) {
        this.buff.put(buff);
    }

    public IoBuffer getBuff() {
        return this.buff;
    }
}

class ServerProtocolCodecFactory implements ProtocolCodecFactory {

    @Override
    public ProtocolEncoder getEncoder(IoSession is) throws Exception {
        return new ServerProtocolEncoder();
    }

    @Override
    public ProtocolDecoder getDecoder(IoSession is) throws Exception {
        return new ServerProtocolDecoder();
    }
}

class ChatProtocolHandler implements IoHandler {

    @Override
    public void sessionCreated(IoSession is) throws Exception {
        ConstHelper.AddLoggerInfo("socket创建" + is);
    }

    @Override
    public void sessionOpened(IoSession is) throws Exception {
        ConstHelper.AddLoggerInfo("socket连接" + is);
    }

    @Override
    public void sessionClosed(IoSession is) throws Exception {
        ConstHelper.AddLoggerInfo("socket关闭" + is);
    }

    @Override
    public void sessionIdle(IoSession is, IdleStatus is1) throws Exception {
        ConstHelper.AddLoggerInfo("socket空闲" + is);
    }

    @Override
    public void exceptionCaught(IoSession is, Throwable thrwbl) throws Exception {
        ConstHelper.AddLoggerInfo("socket异常" + is);
        thrwbl.printStackTrace();
    }

    @Override
    public void messageReceived(IoSession session, Object o) throws Exception {

        if (o instanceof Message) {
            Message message = (Message) o;
            ///找到序号为1的属性，取值
            Descriptors.EnumValueDescriptor field = (Descriptors.EnumValueDescriptor) message.getField(message.getDescriptorForType().findFieldByNumber(1));
            int msgID = field.getNumber(); // 100201

            ConstHelper.AddLoggerInfo("socket数据接收" + session + " :: " + msgID);
            switch (msgID) {
                case LoginMessage.Protos.ReqLogin_VALUE:
                    break;
                case UserVersionMessage.Protos.ReqUserVersion_VALUE:
                    UserVersionMessage.ResUserVersionMessage.Builder newBuilder = UserVersionMessage.ResUserVersionMessage.newBuilder();
                    UserVersionMessage.ReqUserVersionMessage req = (UserVersionMessage.ReqUserVersionMessage) o;
                    newBuilder.setPstrIP(req.getVersion());
                    UserVersionMessage.ResUserVersionMessage rs = newBuilder.build();
                    session.write(rs);
                    break;
            }
        } else {
            System.out.println("!!!!!!!!!!");
        }

//
//        LoginMessage.ReqLoginMessage login = (LoginMessage.ReqLoginMessage) o;
//
//        LoginMessage.ResLoginMessage resLoginMessage = null;
//        {
//            LoginMessage.ResLoginMessage.Builder newBuilder = LoginMessage.ResLoginMessage.newBuilder();            
//            newBuilder.setUsername(login.getUsername());
//            newBuilder.setPassword("123456");
//            resLoginMessage = newBuilder.build();
//        }
//        
//        if (resLoginMessage != null) {
//            // messageSent(session, resLoginMessage);
//            session.write(resLoginMessage);
//        }
    }

    @Override
    public void messageSent(IoSession session, Object o) throws Exception {
        ConstHelper.AddLoggerInfo("socket数据发送" + session);
        // session.write(o);
    }
}
