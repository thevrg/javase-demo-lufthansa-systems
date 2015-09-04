/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.dpc.edu.javase.demo.threads.concurrent;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 *
 * @author U122951
 */
public class ExecutorDemo {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ExecutorService es = Executors.newFixedThreadPool(2);
        MyCallableTask task1 = new MyCallableTask("Task1", 3000);
        MyCallableTask task2 = new MyCallableTask("Task2", 2000);
        MyCallableTask task3 = new MyCallableTask("Task3", 6000);
        Future<String> task1Future = es.submit(task1);
        Future<String> task2Future = es.submit(task2);
        Future<String> task3Future = es.submit(task3);
        System.out.println("dolgoz-doloz...");
        
        task1Future.cancel(true);
        
        //String task3Result = task3Future.get();
        //System.out.println("task3Result: " + task3Result);
        task2Future.get();
        es.shutdown();
              
    }
}
