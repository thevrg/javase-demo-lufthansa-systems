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
public class UglyThreadCreationDemo {
    public static void main(String[] args) {
        MyUglyTask myUglyTask = new MyUglyTask("UglyThread");
        myUglyTask.start();
        Thread t2 = new Thread(myUglyTask, "T2");
        t2.start();
    }
}
