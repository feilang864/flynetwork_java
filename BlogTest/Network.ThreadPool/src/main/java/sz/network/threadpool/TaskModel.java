/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sz.network.threadpool;

import org.apache.log4j.Logger;
import sz.pool.ObjectAttribute;

/**
 * 任务模型
 *
 * @author 失足程序员
 * @Blog http://www.cnblogs.com/ty408/
 * @mail 492794628@qq.com
 * @phone 13882122019
 *
 */
public abstract class TaskModel {

    private static final Logger log = Logger.getLogger(TaskModel.class);

    private long ID;
    private String Name;
    //运行时数据
    private ObjectAttribute runAttribute = new ObjectAttribute();

    public TaskModel(long ID, String Name) {
        this.ID = ID;
        this.Name = Name;
        this.runAttribute.put("submitTime", System.currentTimeMillis());
    }

    public TaskModel() {
        this(0, "无名");
    }

    public long getSubmitTime() {
        return this.runAttribute.getlongValue("submitTime");
    }

    public ObjectAttribute getRunAttribute() {
        return runAttribute;
    }

    public void setRunAttribute(ObjectAttribute runAttribute) {
        this.runAttribute = runAttribute;
    }

    public long getID() {
        return ID;
    }

    public String getName() {
        return Name;
    }

    public abstract void run();

    @Override
    public String toString() {
        return "TaskModel{" + "ID=" + ID + ", Name=" + Name + ", runAttribute=" + runAttribute + '}';
    }

}
