package hu.dpc.edu.javase.demo;

/**
 *
 * @author vrg
 */
public class Manager extends Employee {
    
    public long id;

    private String department;

    public Manager(long id, String name, double salary, String department) {
        super(salary, name, id);
        this.department = department;
    }
    
    public Manager(String name, double salary, String department ) {
        super(salary, name);
        this.department = department;
    }

    public Manager(String department) {
        this.department = department;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Override
    protected void getAttributeValues(StringBuilder sb) {
        super.getAttributeValues(sb);
        sb.append(", department=").append(department);
    }
}
