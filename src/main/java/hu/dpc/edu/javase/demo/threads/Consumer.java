package hu.dpc.edu.javase.demo.threads;

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author U122951
 */
public class Consumer implements Runnable{

    private Random random = new Random();
    private MyStack stack;

    public Consumer(MyStack stack) {
        this.stack = stack;
    }
    
    @Override
    public void run() {
        for (int i = 0; i < 50; ) {
            try {
                char c = stack.pop();
                //System.out.println("popped " + c);
                i++;
                try {
                    Thread.sleep(random.nextInt(500)+ 400);
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
            } catch (IllegalStateException ex) {
               // System.out.println(ex.getMessage());
            }
        }
    }
    
}
