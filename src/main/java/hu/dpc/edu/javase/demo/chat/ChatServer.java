package hu.dpc.edu.javase.demo.chat;

import hu.dpc.edu.javase.demo.net.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 *
 * @author u122951
 */
public class ChatServer {

    private ChatServer(int port, ChatRouter chatRouter) throws IOException {
        ExecutorService executor = Executors.newFixedThreadPool(20);
        ServerSocket ss = new ServerSocket(port);
        while (true) {
            Socket socket = ss.accept();
            ClientHandler handler = new ClientHandler(socket, chatRouter);
            executor.execute(handler);
        }
    }

    public static void main(String[] args) throws IOException {
        ChatRouter chatRouter = new ChatRouterImpl();
        new ChatServer(8000, chatRouter);
    }
}
