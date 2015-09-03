package hu.dpc.edu.javase.demo.generics;

import hu.dpc.edu.javase.demo.Employee;

/**
 *
 * @author U122951
 */
public class EmployeeDAO extends InMemoryDAO<Employee, Long> {

    public EmployeeDAO() {
        super(Employee.class);
    }
}
