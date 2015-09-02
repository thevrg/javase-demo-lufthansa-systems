package hu.dpc.edu.javase.demo;

/**
 *
 * @author u122951
 */
public class Department {

    private String name;
    private long changedAt;

    private Employee[] employees = new Employee[10];
    private int numberOfEmployees;

    {
        setChangedAt();
    }
    
    public String getName() {
        return name;
    }
    
    private void setChangedAt() {
        changedAt = System.nanoTime();
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean addEmployee(Employee emp) {
        if (numberOfEmployees >= employees.length) {
            Employee[] newEmployeeArray = new Employee[employees.length * 2];
            System.arraycopy(employees, 0, newEmployeeArray, 0, employees.length);
            employees = newEmployeeArray;
        }
        employees[numberOfEmployees++] = emp;
        setChangedAt();
        return true;
    }

    public Employee getEmployee(int index) throws IndexOutOfBoundsException {
        checkIndex(index);
        return employees[index];
    }

    private void checkIndex(int index) throws IndexOutOfBoundsException {
        if (index < 0) {
            throw new IndexOutOfBoundsException("Index cannot be negative");
        } else if (index >= numberOfEmployees) {
            throw new IndexOutOfBoundsException("Index is too large");
        }
    }

    public int getNumberOfEmployees() {
        return numberOfEmployees;
    }

    public boolean removeEmployee(Employee emp) {
        for (int i = 0; i < numberOfEmployees; i++) {
            Employee employee = employees[i];
            if (employee.equals(emp)) {
                return removeEmployee(i);
            }
        }
        return false;
    }

    public boolean removeEmployee(int index) {
        checkIndex(index);
        if (index != numberOfEmployees - 1) {
            int numberOfElementsToMove = numberOfEmployees - index - 1;
            System.arraycopy(employees, index + 1, employees, index, numberOfElementsToMove);
        }
        numberOfEmployees--;
        employees[numberOfEmployees] = null;
        setChangedAt();
        return true;
    }

    public EmployeeIterator iterator() {
        return new EmployeeIterator() {
            private int iteratorIndex;
            private long createdAt = System.nanoTime();
            
            private void checkChangedState() {
                if (createdAt < Department.this.changedAt) {
                    throw new IllegalStateException("Department has changed since the creation of this iterator");
                }
            }

            @Override
            public boolean hasNext() throws IllegalStateException {
                checkChangedState();
                return iteratorIndex < numberOfEmployees;
            }

            @Override
            public Employee next() throws IllegalStateException {
                checkChangedState();
                try {
                    return getEmployee(iteratorIndex++);
                } catch (IndexOutOfBoundsException ex) {
                    throw new IllegalStateException("No more elements");
                }
            }
        };
    }

}
