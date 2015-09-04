package hu.dpc.edu.javase.demo;

import hu.dpc.edu.javase.demo.generics.Entity;
import java.util.concurrent.atomic.AtomicInteger;

/**
 *
 * @author vrg
 */
public class Employee extends MyBaseClass implements Entity<Long> {

    public static final double DEFAULT_SALARY;
    private static final AtomicInteger counter = new AtomicInteger();
    private double salary;
    private String name;
    public long id;

    private static long generateId() {
        return counter.incrementAndGet();
    }

    static {
        DEFAULT_SALARY = 1000;
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

    @Override
    public Long getId() {
        return id;
    }

    public static int getCounter() {
        return counter.get();
    }

    @Override
    protected void getAttributeValues(StringBuilder sb) {
        sb.append("salary=").append(salary);
        sb.append("name=").append(name);
        sb.append("id=").append(id);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + (int) (this.id ^ (this.id >>> 32));
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Employee other = (Employee) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }
    
    

}
