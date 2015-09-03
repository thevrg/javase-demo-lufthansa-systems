package hu.dpc.edu.javase.demo.generics;

import hu.dpc.edu.javase.demo.Employee;
import hu.dpc.edu.javase.demo.Manager;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author U122951
 */
public class ToArrayDemo {
    public static void main(String[] args) {
        List<Employee>el = new ArrayList<>();
        el.add(new Employee("Bela"));
        el.add(new Manager("Jozsi", 1111,"Berszamfejtes"));
        el.add(new Employee("Feri"));    
        Object[] array = el.toArray();
        System.out.println("array.length: " + array.length);
        for (Object e : array) {
            System.out.println("e: " + e);
        }
        
        Employee[] empArr = new Employee[2];
        Object[] objArr = empArr;
        
       // objArr[0] = "hello";
        
        Employee[] ebbe = el.toArray(empArr);
        System.out.println("ebbe: " + Arrays.toString(ebbe));
        System.out.println("ebbe.getClass: " + ebbe.getClass());
        System.out.println("ebbe == empArr: "  + (ebbe == empArr));
    }
}
