package com.game.io.mina;

import com.game.io.mina.conf.ServerConfig;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

/**
 *
 * @author Vicky
 */
public abstract class Server implements Runnable {

    public static final String DEFAULT_MAIN_THREAD = "Main";

    protected ServerConfig serverConfig;

    protected Server(ServerConfig serverConfig) {
        this.serverConfig = serverConfig;
    }

    @Override
    public void run() {
        Runtime.getRuntime().addShutdownHook(new Thread(new CloseByExit(getName())));
    }

    public String getName() {
        return this.serverConfig.getName();
    }

    public int getId() {
        return this.serverConfig.getId();
    }

    public String getWeb() {
        return this.serverConfig.getWeb();
    }

    protected abstract void stop();

    private class CloseByExit implements Runnable {

        private final Logger log = LogManager.getLogger(CloseByExit.class);
        private final String server_name;

        public CloseByExit(String server_name) {
            this.server_name = server_name;
        }

        @Override
        public void run() {
            Server.this.stop();
            log.info(this.server_name + " Stop!");
        }
    }
}
