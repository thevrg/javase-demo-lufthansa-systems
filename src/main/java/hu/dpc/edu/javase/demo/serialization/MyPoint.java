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
    public int hashCode() {
        System.out.println("hashCode()");
        int hash = 3;
        hash = 29 * hash + this.y;
        hash = 29 * hash + this.x;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        System.out.println("equals()");
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final MyPoint other = (MyPoint) obj;
        if (this.y != other.y) {
            return false;
        }
        if (this.x != other.x) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "MyPoint{" + "x=" + x + ", y=" + y + '}';
    }

   
    public int compareTo(Object o) {
        System.out.println("compareTo");
        MyPoint other = (MyPoint) o;
        int result = x - other.x;
        if (result == 0) {
            result = y - other.y;
        }
        return result;
    }
    
}
