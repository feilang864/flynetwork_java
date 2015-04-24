package sz.network.socketpool.nettypool;

import org.apache.log4j.Logger;

/**
 *
 * @author Troy.Chen
 */
public abstract class NettyTcpHandler {

    private static final Logger log = Logger.getLogger(NettyTcpHandler.class);

    public NettyTcpHandler() {

    }

    public abstract void action();

}
