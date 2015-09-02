/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.dpc.edu.javase.demo.io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Writer;

/**
 *
 * @author u122951
 */
public class IODemo2 {

    
    public static void copy(Reader from, Writer to) throws IOException {
        try (BufferedReader reader = new BufferedReader(from);
                BufferedWriter writer = new BufferedWriter(to)) {
            
            String line;
            while ((line = reader.readLine()) != null) {
                writer.write(line);
                writer.newLine();
            }
        }
    }
    
    public static void main(String[] args) throws IOException {
        LineNumberReader lnr = null;
        Reader reader = new CharReplacerFilterReader(
                lnr = new LineNumberReader(new InputStreamReader(new FileInputStream("pom.xml"), "UTF-8"))
                ,'<','#');
        Writer writer = new OutputStreamWriter(new FileOutputStream("ebbe.xml"), "UTF-8");
        
        copy(reader,writer);
        
        if (lnr != null) {
            System.out.println("lnr.lineNumber:" + lnr.getLineNumber());
        }
    }
}
