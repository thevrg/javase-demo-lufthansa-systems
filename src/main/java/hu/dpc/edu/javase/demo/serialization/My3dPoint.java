package hu.dpc.edu.javase.demo.serialization;

import java.io.Serializable;

/**
 *
 * @author u122951
 */
public class My3dPoint extends MyPoint implements Serializable {

    private int z;

    private MyPoint next;

    public My3dPoint(int x, int y, int z) {
        super(x, y);
        this.z = z;
        System.out.println("My3Point constructed");
    }

//    private void writeObject(ObjectOutputStream out) throws IOException {
//        out.writeInt(x);
//        out.writeInt(y);
//        out.writeInt(z);
//    }
//
//    private void readObject(ObjectInputStream in) throws IOException {
//        x = in.readInt();
//        y = in.readInt();
//        z = in.readInt();
//    }
    public int getZ() {
        return z;
    }

    public void setZ(int z) {
        this.z = z;
    }

    public MyPoint getNext() {
        return next;
    }

    public void setNext(MyPoint next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return "MyPoint{" + "x=" + x + ", y=" + y + ", z=" + z + ", hasNext : " + (next != null) + '}';
    }

}
