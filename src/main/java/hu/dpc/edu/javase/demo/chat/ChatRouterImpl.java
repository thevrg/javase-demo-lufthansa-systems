/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.dpc.edu.javase.demo.chat;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author U122951
 */
public class ChatRouterImpl implements ChatRouter{

    List<ChatClient>clients = new ArrayList<>();
    
    @Override
    public synchronized void broadcast(String message) {
        for (ChatClient client : clients) {
            client.send(message);
        }
    }

    @Override
    public synchronized void register(ChatClient client) {
        clients.add(client);
    }

    @Override
    public synchronized void unregister(ChatClient client) {
        clients.remove(client);
    }
    
}
