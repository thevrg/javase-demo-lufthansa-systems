/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.dpc.edu.javase.demo.threads.concurrent;

import java.util.concurrent.Callable;

/**
 *
 * @author U122951
 */
public class MyCallableTask implements Callable<String> {

    private String taskName;
    private long sleepTime;

    public MyCallableTask(String taskName, long sleepTime) {
        this.taskName = taskName;
        this.sleepTime = sleepTime;
    }

    @Override
    public String call() throws Exception {
        String tn = Thread.currentThread().getName();
        try {
            System.out.println(tn + ": myTask started: " + taskName);
            Thread.sleep(sleepTime);
            throw new RuntimeException("Exception occured in " + taskName);
        } catch (InterruptedException ex) {
            System.out.println(tn + ": interrupted...");
            throw ex;
        } finally {
            System.out.println(tn + ": myTask completed: " + taskName);
        }
    }

}
