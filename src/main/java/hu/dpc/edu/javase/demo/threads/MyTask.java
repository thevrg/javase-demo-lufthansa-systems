package hu.dpc.edu.javase.demo.threads;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author U122951
 */
public class MyTask implements Runnable {

    private int i;

    @Override
    public void run() {
        String tn = Thread.currentThread().getName();

        System.out.println(tn + ": MyTask started");
        while (i < 50) {
            if (Application.INSTANCE.isTimeToQuit()) {
                System.out.println(tn + ": Exiting thread...");
                return;
            }
            System.out.println(tn + ": i = " + i);
            try {
                Thread.sleep(50);
            } catch (InterruptedException ex) {
                if (Application.INSTANCE.isTimeToQuit()) {
                    System.out.println(tn + ": Interrupt, exiting thread...");
                    return;
                }
            }
            i++;
        }
        System.out.println(tn + ": MyTask Finished");
    }

}
