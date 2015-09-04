package hu.dpc.edu.javase.demo.threads;

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author U122951
 */
public class Producer implements Runnable{

    private Random random = new Random();
    private MyStack stack;

    public Producer(MyStack stack) {
        this.stack = stack;
    }
    
    @Override
    public void run() {
        for (int i = 0; i < 50; i++) {
            char c = (char) ('A' + random.nextInt('Z' - 'A'));
            stack.push(c);
            try {
                Thread.sleep(random.nextInt(500));
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
    }
    
}
