package hu.dpc.edu.javase.demo;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author vrg
 */
public class EmployeeTest {
    
    public EmployeeTest() {
    }

    /**
     * Test of getSalary method, of class Employee.
     */
    @Test
    public void testGetSalaryReturnsTheSalaryPassedInConstructor() {
        //Given
        Employee instance = new Employee(1000D, "Bela", 101L);
        //When
        double result = instance.getSalary();
        //Then
        assertEquals(1000D, result, 0.001);
    }

  
    
}
