/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.dpc.edu.javase.demo.overloading;

import java.util.Date;

/**
 *
 * @author vrg
 */
public class TestOverloading {
    
    public static void hello(String a, Date d) {
        System.out.println("String, Date");
    }
    
    public static int hello(Date a, String d) {
        System.out.println("Date, String");
        return 1;
    }
    
    public static void hello(Date a, String... d) {
        System.out.println("Date, String...");
    }
    
    public static void alma(int i) {
        System.out.println("int");
    }
    public static void alma(long l) {
        System.out.println("long");
    }
    public static void alma(double d) {
        System.out.println("double");
    }
    public static void alma(byte b) {
        System.out.println("byte");
    }
            
    
    public static void main(String[] args) {
        hello("", null);
        hello((Date)null,(String)null);
        hello(null, null, null);
        hello(null, "alma");
        alma((byte)3);
    }
}
