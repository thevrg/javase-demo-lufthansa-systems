
package hu.dpc.edu.javase.demo;

/**
 *
 * @author u122951
 */
public class ManagerFactory extends EmployeeFactory {

    private String department;

    public ManagerFactory(String department) {
        this.department = department;
    }
    
    @Override
    public Manager create(long id, double salary, String name) {
        return new Manager(id, name, salary, department);
    }
    
}
