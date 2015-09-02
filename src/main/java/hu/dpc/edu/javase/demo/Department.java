package hu.dpc.edu.javase.demo;

/**
 *
 * @author u122951
 */
public class Department {

    private String name;

    private Employee[] employees = new Employee[10];
    private int numberOfEmployees;

    public String getName() {
        return name;
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
        return true;
    }

    public Employee getEmployee(int index) {
        if (!isIndexValid(index)) {
            return null;
        }
        return employees[index];
    }

    private boolean isIndexValid(int index) {
        if (index < 0) {
            return false;
        } else if (index >= numberOfEmployees) {
            return false;
        }
        return true;
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
        if (!isIndexValid(index)) {
            return false;
        }

        if (index != numberOfEmployees - 1) {
            int numberOfElementsToMove = numberOfEmployees - index - 1;
            System.arraycopy(employees, index + 1, employees, index, numberOfElementsToMove);
        }
        numberOfEmployees--;
        employees[numberOfEmployees] = null;
        return true;
    }

    public EmployeeIterator iterator() {
        return new EmployeeIterator() {
            private int iteratorIndex;

            @Override
            public boolean hasNext() {
                return iteratorIndex < numberOfEmployees;
            }

            @Override
            public Employee next() {
                if (!isIndexValid(iteratorIndex)) {
                    return null;
                }
                return getEmployee(iteratorIndex++);
            }
        };
    }

}
