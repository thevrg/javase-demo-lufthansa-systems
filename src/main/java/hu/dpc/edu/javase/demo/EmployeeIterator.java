/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.dpc.edu.javase.demo;

/**
 *
 * @author u122951
 */
public interface EmployeeIterator {
    public boolean hasNext();
    public Employee next();
    public void reset();
    
}
