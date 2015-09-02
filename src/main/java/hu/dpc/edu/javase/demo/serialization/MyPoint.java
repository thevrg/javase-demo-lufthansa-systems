package hu.dpc.edu.javase.demo.serialization;

import java.io.Serializable;

/**
 *
 * @author u122951
 */
public class MyPoint implements Serializable {
    protected int y = 20;
    protected transient int x = 10;

    
    private final static long serialVersionUID = 2L;

    public MyPoint() {
        System.out.println("MyPoint() constructed");
    }
    
    public MyPoint(int x, int y) {
        this.x = x;
        this.y = y;
        System.out.println("MyPoint(x,y) constructed");
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    @Override
    public String toString() {
        return "MyPoint{" + "x=" + x + ", y=" + y + '}';
    }
    
}
