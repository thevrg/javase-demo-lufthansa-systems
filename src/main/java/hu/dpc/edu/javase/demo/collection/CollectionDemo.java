/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.dpc.edu.javase.demo.collection;

import hu.dpc.edu.javase.demo.Employee;
import hu.dpc.edu.javase.demo.serialization.MyPoint;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 *
 * @author U122951
 */
public class CollectionDemo {

    public static void main(String[] args) {
        SortedSet c = new TreeSet(EmployeeComparator.BY_NAME);
//        c.add("Egy");
//        c.add("Ketto");
//        c.add(3);
//        c.add(4);
//        c.add(new MyPoint(65,66));
//        c.add(new MyPoint(65,66));
//        c.add(new MyPoint(65,67)); 
//        c.add(new MyPoint(66,67)); 
        c.add(new Employee(111, "Bela", 122L));
        c.add(new Employee(111, "Bela", 122L));
        c.add(new Employee(112, "Jozsi", 121L));
        c.add(new Employee(111234, "Zsolt", 12L));
//        c.add(3);
//        c.add(new String("Ketto"));
//        c.add("Harom");
//        c.add("Zero");
//        c.add("Alma");
        SortedSet subSet = c.subSet(new Employee("Bela"), new Employee("Jozsi"));

        System.out.println("c: " + c);
        System.out.println("subSet: " + subSet);
        c.add(new Employee("Cecil"));

        System.out.println("subSet: " + subSet);
        subSet.add(new Employee("Denes"));
        System.out.println("subSet: " + subSet);

        System.out.println("c: " + c);

        List empList = new ArrayList();

        empList.add(new Employee(111, "Bela", 122L));
        empList.add(new Employee(111, "Bela", 122L));
        empList.add(new Employee(112, "Jozsi", 121L));
        empList.add(new Employee(111234, "Zsolt", 12L));
        
        Collections.sort(empList, EmployeeComparator.BY_ID);

        Collections.shuffle(empList);
        System.out.println("empList: " + empList);
    }
}
