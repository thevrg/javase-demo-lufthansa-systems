/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.dpc.edu.javase.demo.generics;

import hu.dpc.edu.javase.demo.Employee;
import hu.dpc.edu.javase.demo.Manager;

/**
 *
 * @author U122951
 */
public class CsodaDemo {
    public static void main(String[] args) {
        Object o = new Manager("HR");
        Employee e = Csoda.cast(o);
        String s = Csoda.cast(o);
        System.out.println("e: " + e);
    }
}
