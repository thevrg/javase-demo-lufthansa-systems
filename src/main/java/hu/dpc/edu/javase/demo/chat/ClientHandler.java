package hu.dpc.edu.javase.demo.chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author U122951
 */
public class ClientHandler implements Runnable, ChatClient {

    private final Socket socket;
    private final ChatRouter router;
    private PrintWriter out;

    public ClientHandler(Socket socket, ChatRouter router) {
        this.socket = socket;
        this.router = router;
    }

    @Override
    public void run() {
        System.out.println("Client connected: " + socket.getInetAddress());
        String name = socket.getRemoteSocketAddress().toString();
        try (PrintWriter w = out = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), "UTF-8"))) {
            router.register(this);
            try (BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream(), "UTF-8"));) {
                String message;
                while ((message = in.readLine()) != null) {
                    System.out.println(name + ": " + message);
                    router.broadcast(name + ": " + message);
                }
            }
        } catch (IOException ex) {
            ex.printStackTrace();
            return;
        } finally {
            router.unregister(this);
        }
    }

    @Override
    public synchronized void send(String message) {
        if (out != null) {
            out.println(message);
            out.flush();
        }
    }

}
