package hu.dpc.edu.javase.demo.threads;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author U122951
 */
public class MyStack {

    private char[] buffer = new char[10];
    private int index;
    //private final Object lock = new Object();
    private final ReadWriteLock readWriteLock = new ReentrantReadWriteLock();
    private final Lock READ_LOCK = readWriteLock.readLock();
    private final Lock WRITE_LOCK = readWriteLock.writeLock();
    private final Condition NOT_EMPTY = WRITE_LOCK.newCondition();
    private final Condition NOT_FULL = WRITE_LOCK.newCondition();

    public void push(char c) {
        String tn = Thread.currentThread().getName();
        WRITE_LOCK.lock();
        try {
            while (index == buffer.length - 1) {
                try {
                    NOT_FULL.await();
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
            }
            System.out.println(tn + ": pushed " + c);
            buffer[index++] = c;
            NOT_EMPTY.signal();
        } finally {
            WRITE_LOCK.unlock();
        }

    }

    public char pop() {
        String tn = Thread.currentThread().getName();

        WRITE_LOCK.lock();
        try {
            System.out.println(tn + ": pop");
            while (index == 0) {
                try {
                    NOT_EMPTY.await();
                    if (index == 0) {
                        System.out.println(tn + ": VAKLARMAAAAAAA!!!!!!!");
                    }
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
            }
            char c = buffer[--index];
            NOT_FULL.signal();
            System.out.println(tn + ": popped " + c);
            return c;
        } finally {
            WRITE_LOCK.unlock();
        }
    }

    public int size() {
        try {
            READ_LOCK.lock();
            return index;
        } finally {
            READ_LOCK.unlock();
        }
    }

}
