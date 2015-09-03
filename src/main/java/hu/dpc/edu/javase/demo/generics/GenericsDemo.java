package hu.dpc.edu.javase.demo.generics;

import hu.dpc.edu.javase.demo.Employee;
import hu.dpc.edu.javase.demo.Manager;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author U122951
 */
public class GenericsDemo {
    public static void main(String[] args) {
        List<Employee>el = new ArrayList<>();
        el.add(new Employee("Bela"));
        el.add(new Manager("Jozsi", 1111,"Berszamfejtes"));
        el.add(new Employee("Feri"));
        //el.add("ssd");
        Employee first = el.get(1);
        System.out.println("first: " + first);
        
        List<Manager>ml = new ArrayList<>();
        ml.add(new Manager("Jozsi", 1111,"Berszamfejtes"));
        ml.add(new Manager("Masik Jozsi", 1112,"HR"));
        
        List<?>lu = ml;
        lu.add(null);
        Object zero = lu.get(0);
        System.out.println("zero: " + zero);
        
        List<? extends Employee>lee = ml;
        lee.add(null);
        Employee first2 = lee.get(1);
        System.out.println("first2: " + first2);
        lee.contains(new Employee("Bela"));
        
        
        List<? super Manager>lsm = el;
        
        lsm.add(new Manager("XXX"));
        Object get = lsm.get(0);
        
        
        
        List l = ml;
        l.add("hello");
        l.add(113);
        
        System.out.println("ml: " + ml);
        //Manager m = ml.get(4);
        
    }
}
