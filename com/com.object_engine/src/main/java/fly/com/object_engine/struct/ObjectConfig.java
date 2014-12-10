/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fly.com.object_engine.struct;

import java.util.Random;

/**
 *
 * @author Administrator
 */
public class ObjectConfig {

    private static final Object obj = new Object();
    private static long staticID = 0;
    private static int serverID = new Random().nextInt(1000000);

    public static long getId() {
        synchronized (obj) {
            staticID += 1;
            return (serverID & 0xFFFF) << 48 | (System.currentTimeMillis() / 1000L & 0xFFFFFFFF) << 16 | staticID & 0xFFFF;
        }
    }

    private static boolean running = true;

    public static boolean isRunning() {
        return running;
    }

}
