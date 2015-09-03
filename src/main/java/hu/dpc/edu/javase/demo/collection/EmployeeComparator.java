
package hu.dpc.edu.javase.demo.collection;

import hu.dpc.edu.javase.demo.Employee;
import java.util.Comparator;

/**
 *
 * @author U122951
 */
public enum EmployeeComparator implements Comparator<Employee>{
    BY_NAME {

        @Override
        public int compare(Employee o1, Employee o2) {
            return o1.getName().compareTo(o2.getName());
        }
        
    },
    BY_ID {

        @Override
        public int compare(Employee o1, Employee o2) {
            return (int) (o1.getId() - o2.getId());
        }
        
    };
    
    public Comparator<Employee> descending() {
        return new Comparator<Employee>() {

            @Override
            public int compare(Employee o1, Employee o2) {
                return - EmployeeComparator.this.compare(o1, o2);
            }
        };
    }
    
}
