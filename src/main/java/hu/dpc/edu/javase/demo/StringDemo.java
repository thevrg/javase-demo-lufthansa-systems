package hu.dpc.edu.javase.demo;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 *
 * @author vrg
 */
public class StringDemo {
    public static void main(String[] args) {
        String a = "AB".concat("C");
        String b = "A".concat("BC");
        String c = a.intern();
        String d = b.intern();
        String e = "ABC";
        System.out.println("a == b : " + (a == b) );
        System.out.println("c == d : " + (c == d));
        System.out.println("a == c : " + (a == c));
        System.out.println("b == c : " + (b == c));
        System.out.println("c == e : " + (c == e));
        System.out.println("a.equals(b) : " + a.equals(b));
        Object o = new Manager("HR");
        System.out.println(o.getClass().getSimpleName());
        
        Field[] fields = o.getClass().getDeclaredFields();
        for (Field field : fields) {
            System.out.println("found " + field);
        }
        
        Method[] methods = o.getClass().getMethods();
        for (Method method : methods) {
            System.out.println("found " + method );
        }
        
        
        System.out.println("o.class: " + o.getClass());
        System.out.println("o instanceof Employee: " + (o instanceof Employee));
        
        System.out.println("o: " + o);
    }
}
