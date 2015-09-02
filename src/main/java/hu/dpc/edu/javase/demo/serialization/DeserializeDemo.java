package hu.dpc.edu.javase.demo.serialization;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

/**
 *
 * @author u122951
 */
public class DeserializeDemo {
    public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
        My3dPoint p = null;
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("ebbe.ser"))) {
            p = (My3dPoint) in.readObject();
            System.out.println("p: " + p);
            
            MyPoint next = p.getNext();
            System.out.println("p.next: " + next);
        }
    }
}
