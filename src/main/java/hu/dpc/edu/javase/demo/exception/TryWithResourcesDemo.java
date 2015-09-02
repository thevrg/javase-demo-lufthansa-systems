/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.dpc.edu.javase.demo.exception;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author u122951
 */
public class TryWithResourcesDemo {
    public static void main(String[] args) throws IOException {
        
        
        try (
                MyResource r1 = new MyResource("R1");
                MyResource r2 = new MyResource("R2");
                FileInputStream in = new FileInputStream("pom.xml");
                MyResource r3 = new MyResource("R3");
                ) {
            in.read();
        } catch (Exception ex) {
            ex.addSuppressed(new OutOfMemoryError("Csak viccelek"));
            ex.printStackTrace();
        }
    }
}
