/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.dpc.edu.javase.demo.threads;

/**
 *
 * @author U122951
 */
public class MyUglyTask extends Thread {

    public MyUglyTask(String name) {
        super(name);
    }
    
    @Override
    public void run() {
        String tn = Thread.currentThread().getName();
        System.out.println(tn + ": this is another task");
    }
    
}
