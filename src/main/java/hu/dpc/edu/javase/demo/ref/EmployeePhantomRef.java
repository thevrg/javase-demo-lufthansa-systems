/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.dpc.edu.javase.demo.ref;

import hu.dpc.edu.javase.demo.Employee;
import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;

/**
 *
 * @author U122951
 */
public class EmployeePhantomRef extends PhantomReference<Employee>{

    private long id;
    
    public EmployeePhantomRef(Employee referent, ReferenceQueue<? super Employee> q) {
        super(referent, q);
        this.id = referent.getId();
    }

    public long getId() {
        return id;
    }

    @Override
    public String toString() {
        return "EmployeePhantomRef{" + "id=" + id + '}';
    }
    
    
    
}
