/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.dpc.edu.javase.demo.net;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

/**
 *
 * @author u122951
 */
public class MyClient {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localhost", 8000);
        try(BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream(),"UTF-8"))){
            String readLine;
            while((readLine= in.readLine()) != null) {
                System.out.println("line read: " + readLine);
            }
        }
    }
}
