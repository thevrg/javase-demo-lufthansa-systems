package hu.dpc.edu.javase.demo.threads;

import java.util.Timer;
import java.util.TimerTask;

/**
 *
 * @author U122951
 */
public class ThreadDemo {
    public static void main(String[] args) throws InterruptedException {
        MyTask task = new MyTask();
        Thread t1 = new Thread(task, "T1");
        Thread t2 = new Thread(task, "T2");
        Application.INSTANCE.registerThread(t1);
        Application.INSTANCE.registerThread(t2);
        
        t1.setPriority(Thread.MAX_PRIORITY);
        t1.join();
        System.out.println("t1.isAlive: " +t1.isAlive());//1.
        t1.start();
        t2.start();
        System.out.println("t1.isAlive: " +t1.isAlive());//2.
        
        final Timer t = new Timer();
        t.schedule(new TimerTask() {

            @Override
            public void run() {
                Application.INSTANCE.shutdown();
                //t.cancel();
            }
        }, 1000);
        
        
        t1.join();
        
        System.out.println("t1.isAlive: " +t1.isAlive());//3.
        
        System.out.println("main thread ends...");
    }
}
