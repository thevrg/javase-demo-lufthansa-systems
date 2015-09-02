/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.dpc.edu.javase.demo.io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 *
 * @author u122951
 */
public class IODemo {

    public static void main(String[] args) throws IOException {
        try (FileInputStream fis = new FileInputStream("pom.xml");
                FileOutputStream fos = new FileOutputStream("ebbe.xml")) {
            byte[] buffer = new byte[128];
            
            int readByteCount;
            while((readByteCount = fis.read(buffer)) != -1) {
                fos.write(buffer, 0, readByteCount);
            }
        }
    }
}
