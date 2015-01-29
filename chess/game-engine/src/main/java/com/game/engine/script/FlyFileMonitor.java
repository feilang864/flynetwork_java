package com.game.engine.script;

import java.io.File;
import java.util.ArrayList;
import org.apache.commons.io.monitor.FileAlterationListener;
import org.apache.commons.io.monitor.FileAlterationMonitor;
import org.apache.commons.io.monitor.FileAlterationObserver;
import org.apache.log4j.Logger;

/**
 *
 * @author Troy.Chen
 */
public class FlyFileMonitor {

    private static final Logger log = Logger.getLogger(FlyFileMonitor.class);
    static ArrayList<FileAlterationMonitor> monitors = new ArrayList<>(0);

    /**
     * 初始化监控文件夹
     *
     * @param interval 监控扫描文件的间隔时间
     * @param clazz 继承至 org.apache.commons.io.monitor.FileAlterationListener
     * @param dirPaths 需要监控扫描的文件夹列表
     */
    public FlyFileMonitor(long interval, FileAlterationListener clazz, String... dirPaths) {
        for (String dirPath : dirPaths) {
            FileAlterationObserver observer = new FileAlterationObserver(new File(dirPath));
            observer.addListener(clazz);

            FileAlterationMonitor fileAlterationMonitor = new FileAlterationMonitor(interval);
            fileAlterationMonitor.addObserver(observer);

            monitors.add(fileAlterationMonitor);
            log.info("添加监控：" + observer.getDirectory().getPath());
        }
    }

    public void dispose() {
        try {
            for (FileAlterationMonitor monitor : monitors) {
                monitor.stop();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void start() {
        try {
            for (FileAlterationMonitor monitor : monitors) {
                monitor.start();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

}
