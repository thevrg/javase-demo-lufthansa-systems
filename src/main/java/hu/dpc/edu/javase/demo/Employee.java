package hu.dpc.edu.javase.demo;

/**
 *
 * @author vrg
 */
public class Employee extends MyBaseClass {

    public static final double DEFAULT_SALARY;
    private static int counter = 0;
    private double salary;
    private String name;
    public long id;

    private static long generateId() {
        return ++counter;
    }

    static {
        DEFAULT_SALARY = 1000;
        counter += 1000;
        System.out.println("Employee.class loaded successfully");
    }

    public Employee() {
        id = generateId();
    }

    public Employee(double salary, String name, long id) {
        this.salary = salary;
        this.name = name;
        this.id = id;
    }

    public Employee(String name) {
        this(DEFAULT_SALARY, name);
        this.name = name;
    }

    public Employee(double salary, String name) {
        this(salary, name, generateId());
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public static int getCounter() {
        return counter;
    }

    @Override
    protected void getAttributeValues(StringBuilder sb) {
        sb.append("salary=").append(salary);
        sb.append("name=").append(name);
        sb.append("id=").append(id);
    }

}
