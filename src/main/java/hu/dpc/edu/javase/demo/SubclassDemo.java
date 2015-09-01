/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.dpc.edu.javase.demo;

/**
 *
 * @author u122951
 */
public class SubclassDemo {
    public static void main(String[] args) {
        Manager m = new Manager(111L, "Bela", 222, "HR");
        m.setId(444L);
        Employee e = m;
        System.out.println("m.id" + m.id);
        System.out.println("e.id" + e.id);
    }
}
