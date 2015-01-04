/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fly.game_logic.struct;

import java.io.Serializable;

/**
 * 位置信息
 *
 * @author Troy.Chen
 */
public class Position implements Serializable {

    private static final long serialVersionUID = -6014998981401563742L;

    private float x;
    private float y;
    private float z;

    public Position() {
    }

    public Position(float x, float y, float z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public float getZ() {
        return z;
    }

    public void setZ(float z) {
        this.z = z;
    }

    @Override
    public String toString() {
        return "坐标{" + "x=" + x + ", y=" + y + ", z=" + z + '}';
    }

}
