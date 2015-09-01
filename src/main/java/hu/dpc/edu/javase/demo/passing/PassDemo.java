/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.dpc.edu.javase.demo.passing;

import hu.dpc.edu.javase.demo.Employee;

/**
 *
 * @author vrg
 */
public class PassDemo {
    
    public static void changeValue(int value) {
        value = 33;
    }
    
    public static void changeRef(Employee emp) {
        emp = new Employee("Feri");
    }
    public static void changeObjectState(Employee emp) {
        emp.setName("Bela");
    }
    
    public static void main(String[] args) {
        int value = 11;
        changeValue(value);
        System.out.println("value: " + value);
        
        Employee emp = new Employee("Jozsi");
        changeRef(emp);
        System.out.println("emp: " + emp.getName());
        changeObjectState(emp);
        System.out.println("emp:" + emp.getName());
    }
}
