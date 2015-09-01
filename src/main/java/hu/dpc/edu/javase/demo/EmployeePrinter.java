package hu.dpc.edu.javase.demo;

import java.io.PrintStream;

/**
 *
 * @author u122951
 */
public class EmployeePrinter {
    
    private final PrintStream out;

    public EmployeePrinter() {
        out = System.out;
    }
    
    public EmployeePrinter(PrintStream out) {
        this.out = out;
    }
    
    public void printEmployees(EmployeeIterator iterator) {
        iterator.reset();
        while (iterator.hasNext()) {
            Employee emp = iterator.next();
            out.println(emp);
        }
    }
}
