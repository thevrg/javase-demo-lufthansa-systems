package hu.dpc.edu.javase.demo.threads;

/**
 *
 * @author U122951
 */
public class SynchronizationDemo {

    public static void main(String[] args) {
        MyStack stack = new MyStack();
        Producer p = new Producer(stack);
        Consumer c = new Consumer(stack);

        Thread P1 = new Thread(p, "P1");
        Thread P2 = new Thread(p, "P2");
        Thread C1 = new Thread(c, "C1");
        Thread C2 = new Thread(c, "C2");

        P1.start();
        P2.start();
        C1.start();
        C2.start();

    }
}
