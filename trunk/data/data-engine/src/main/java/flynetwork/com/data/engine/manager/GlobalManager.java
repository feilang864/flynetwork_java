/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flynetwork.com.data.engine.manager;

/**
 *
 * @author fly_troy
 */
public class GlobalManager {

    static GlobalManager instance = new GlobalManager();

    public static GlobalManager getInstance() {
        return instance;
    }
    private ThreadGroup GlobeThreadGroup = new ThreadGroup("全局线程");

    public ThreadGroup getGlobeThreadGroup() {
        return GlobeThreadGroup;
    }

    private boolean running = true;

    public boolean isRunning() {
        return running;
    }

    public void StopServer() {
        running = false;
    }

}
