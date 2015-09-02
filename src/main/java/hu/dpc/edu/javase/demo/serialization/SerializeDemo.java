/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.dpc.edu.javase.demo.serialization;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

/**
 *
 * @author u122951
 */
public class SerializeDemo {

    public static void main(String[] args) throws FileNotFoundException, IOException {
        My3dPoint p = new My3dPoint(65, 66, 67);
        MyPoint next = new MyPoint(11, 22);
        //p.setNext(next);
        //next.setNext(p);
        
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("ebbe.ser"))) {
            out.writeObject(p);
        }
    }
}
