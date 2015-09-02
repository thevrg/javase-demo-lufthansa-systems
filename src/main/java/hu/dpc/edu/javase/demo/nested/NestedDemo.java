/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.dpc.edu.javase.demo.nested;

import hu.dpc.edu.javase.demo.zoo.Dog;
import hu.dpc.edu.javase.demo.zoo.Pet;

/**
 *
 * @author u122951
 */
public class NestedDemo {
    public static void main(String[] args) {
        Outer o1 = new Outer("O1");
        Outer o2 = new Outer("O2");
        Outer.Inner o1i1 = o1.createInner("O1I1");
        Outer.Inner o2i2 = o2.createInner("O2I2");
        System.out.println(o1i1);
        System.out.println(o2i2);
        
        Outer.Inner i3 = o1.new Inner("i3");
        System.out.println(i3);
        
        Pet pet = o2.createLocal("Bodri");
        Pet pet2 = o2.createLocal("Cirmos");
        
        System.out.println("pet.getName: " + pet.getName());
        System.out.println("pet2.getName: " + pet2.getName());
        System.out.println("pet.getName: " + pet.getName());
        System.out.println("pet2.getName: " + pet2.getName());
        System.out.println("pet.getClass().getName(): " + pet.getClass().getName());
        
        Pet p3 = o2.createAnonymous("Frakk");
        Pet p4 = o2.createAnonymous("Frakk2");
        
        System.out.println("p3.name: " + p3.getName());
        System.out.println("p4.name: " + p4.getName());
        
        System.out.println("p3 instanceof Dog: " + (p3 instanceof Dog) );
    }
}
