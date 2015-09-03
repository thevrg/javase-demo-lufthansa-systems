package hu.dpc.edu.javase.demo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author u122951
 */
public class Department {

    private String name;

    //private Employee[] employees = new Employee[10];
    private List employees = new ArrayList();
    private List readOnlyEmployees = Collections.unmodifiableList(employees);
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }

    public boolean addEmployee(Employee emp) {
        return employees.add(emp);
    }

    public Employee getEmployee(int index) throws IndexOutOfBoundsException {
        return (Employee) employees.get(index);
    }

    public int getNumberOfEmployees() {
        return employees.size();
    }

    public boolean removeEmployee(Employee emp) {
        return employees.remove(emp);
    }

    public Employee removeEmployee(int index) {
        return (Employee) employees.remove(index);
    }

    public Iterator iterator() {
        return readOnlyEmployees.iterator();
    }

    public List getEmployees() {
        return readOnlyEmployees;
    }
    
    
}
