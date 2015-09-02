/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.dpc.edu.javase.demo.net;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author u122951
 */
public class MyServer {

    private MyServer(int port) throws IOException {
        ServerSocket ss = new ServerSocket(port);
        while (true) {
            Socket client = ss.accept();
            System.out.println("Client connected: " + client.getInetAddress());

            try (PrintWriter out = new PrintWriter(new OutputStreamWriter(client.getOutputStream(), "UTF-8"));
                    BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream(), "UTF-8"));) {
                String line;
                while ((line = in.readLine()) != null) {
                    out.println(line);
                    out.flush();
                }
            }

        }
    }

    public static void main(String[] args) throws IOException {
        new MyServer(8000);
    }
}
