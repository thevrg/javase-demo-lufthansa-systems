package hu.dpc.edu.javase.demo.ref;

import hu.dpc.edu.javase.demo.Employee;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.util.WeakHashMap;

/**
 *
 * @author U122951
 */
public class PhantomRefDemo {
    public static void main(String[] args) throws InterruptedException {
        
        ReferenceQueue<Employee> rq = new ReferenceQueue();
        EmployeePhantomRef ref = new EmployeePhantomRef(new Employee("Bela"), rq);
        ref.get();
        System.gc();
        
        Thread.sleep(1000);
        
        EmployeePhantomRef r = (EmployeePhantomRef) rq.poll();
        
        System.out.println("r: " + r);
        
        
    }
}
