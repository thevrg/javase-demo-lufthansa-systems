package hu.dpc.edu.javase.demo.chat;

/**
 *
 * @author U122951
 */
public interface ChatRouter {
    public void broadcast(String message);
    public void register(ChatClient client);
    public void unregister(ChatClient client);
}
