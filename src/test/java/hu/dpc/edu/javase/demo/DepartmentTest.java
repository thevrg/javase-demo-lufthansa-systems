package hu.dpc.edu.javase.demo;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author u122951
 */
public class DepartmentTest {

    private Employee emp1;
    private Employee emp2;
    private Employee emp3;

    private Department createHRDepartmentWithThreeEmployees() {
        Department department = new Department();
        department.setName("HR");

        emp1 = new Employee(12345, "Bela", 101L);
        emp2 = new Employee(12347, "Jozsi", 102L);
        emp3 = new Employee(12349, "Feri", 103L);

        department.addEmployee(emp1);
        department.addEmployee(emp2);
        department.addEmployee(emp3);
        return department;
    }

    /**
     * Test of addEmployee method, of class Department.
     */
    @Test
    public void testAddEmployeeShouldReturnWithTrue() {
        //Given
        Department dep = createHRDepartmentWithThreeEmployees();
        Employee emp4 = new Employee(9999, "New", 9992L);
        //When
        boolean addEmployeeResult = dep.addEmployee(emp4);
        //Then
        assertTrue(addEmployeeResult);
    }

    @Test
    public void testAddEmployeeShouldIncreaseNumberOfEmployees() {
        //Given
        Department dep = createHRDepartmentWithThreeEmployees();
        Employee emp4 = new Employee(9999, "New", 9992L);
        //When
        boolean addEmployeeResult = dep.addEmployee(emp4);
        //Then
        assertTrue(addEmployeeResult);
        assertEquals(4, dep.getNumberOfEmployees());
    }

    /**
     * Test of getEmployee method, of class Department.
     */
    @Test
    public void testGetEmployeeWithValidIndexes() {
        //Given
        Department dep = createHRDepartmentWithThreeEmployees();
        //When
        Employee getEmp0Result = dep.getEmployee(0);
        Employee getEmp1Result = dep.getEmployee(1);
        Employee getEmp2Result = dep.getEmployee(2);
        //Then

        assertSame(emp1, getEmp0Result);
        assertSame(emp2, getEmp1Result);
        assertSame(emp3, getEmp2Result);
    }

    @Test
    public void testGetEmployeeReturnsNullForNegativeIndexValues() {
        //Given
        Department dep = createHRDepartmentWithThreeEmployees();
        //When
        Employee getEmpMinusOneResult = dep.getEmployee(-1);
        Employee getEmpMinusThousandResult = dep.getEmployee(-1000);
        //Then
        assertNull(getEmpMinusOneResult);
        assertNull(getEmpMinusThousandResult);
    }

    @Test
    public void testGetEmployeeReturnsNullForNonExistingIndexValues() {
        //Given
        Department dep = createHRDepartmentWithThreeEmployees();
        //When
        Employee getEmpThreeOneResult = dep.getEmployee(3);
        Employee getEmpThousandResult = dep.getEmployee(1000);
        //Then
        assertNull(getEmpThousandResult);
        assertNull(getEmpThousandResult);
    }

    /**
     * Test of getNumberOfEmployees method, of class Department.
     */
    @Test
    public void testGetNumberOfEmployees() {
        //Given
        Department dep = createHRDepartmentWithThreeEmployees();
        //When
        int numberOfEmployees = dep.getNumberOfEmployees();
        //Then

        assertEquals(3, numberOfEmployees);
    }

    /**
     * Test of removeEmployee method, of class Department.
     */
    @Test
    public void testRemoveEmployee_Employee() {
    }

    /**
     * Test of removeEmployee method, of class Department.
     */
    @Test
    public void testRemoveEmployee_int_ShouldReturnFalseWhenIndexIsNegative() {
        //Given
        Department dep = createHRDepartmentWithThreeEmployees();
        //When
        boolean removeEmployeeMinusOneResult = dep.removeEmployee(-1);
        boolean removeEmployeeMinusOneHundredResult = dep.removeEmployee(-100);
        //Then
        assertFalse(removeEmployeeMinusOneResult);
        assertFalse(removeEmployeeMinusOneHundredResult);

    }

    /**
     * Test of removeEmployee method, of class Department.
     */
    @Test
    public void testRemoveEmployee_int_ShouldReturnFalseWhenIndexIsNotValid() {
        //Given
        Department dep = createHRDepartmentWithThreeEmployees();
        //When
        boolean removeEmployeeThreeOneResult = dep.removeEmployee(3);
        boolean removeEmployeeOneHundredResult = dep.removeEmployee(100);
        //Then
        assertFalse(removeEmployeeThreeOneResult);
        assertFalse(removeEmployeeOneHundredResult);

    }

    @Test
    public void testRemoveEmployee_int_ShouldDeleteLastItemProperly() {
        //Given
        Department dep = createHRDepartmentWithThreeEmployees();
        //When
        boolean removeEmployeeResult = dep.removeEmployee(2);
        //Then
        assertTrue("removeEmployee should return true", removeEmployeeResult);
        assertEquals("removeEmployee Should Decrease number of employees", 2, dep.getNumberOfEmployees());
        assertSame(emp1, dep.getEmployee(0));
        assertSame(emp2, dep.getEmployee(1));
    }

    @Test
    public void testRemoveEmployee_int_ShouldDeleteANonLastItemProperly() {
        //Given
        Department dep = createHRDepartmentWithThreeEmployees();
        //When
        boolean removeEmployeeResult = dep.removeEmployee(1);
        //Then
        assertTrue("removeEmployee should return true", removeEmployeeResult);
        assertEquals("removeEmployee Should Decrease number of employees", 2, dep.getNumberOfEmployees());
        assertSame(emp1, dep.getEmployee(0));
        assertSame(emp3, dep.getEmployee(1));
    }

    @Test
    public void testRemoveEmployee_int_ShouldDeleteFirstItemProperly() {
        //Given
        Department dep = createHRDepartmentWithThreeEmployees();
        //When
        boolean removeEmployeeResult = dep.removeEmployee(0);
        //Then
        assertTrue("removeEmployee should return true", removeEmployeeResult);
        assertEquals("removeEmployee Should Decrease number of employees", 2, dep.getNumberOfEmployees());
        assertSame(emp2, dep.getEmployee(0));
        assertSame(emp3, dep.getEmployee(1));
    }
    
    @Test
    public void testEmployeeIterator() {
        //Given
        Department dep = createHRDepartmentWithThreeEmployees();
        EmployeeIterator it = dep.iterator();
        //When
        boolean hasNext1 = it.hasNext();
        Employee next1 = it.next();
        boolean hasNext2 = it.hasNext();
        Employee next2 = it.next();
        boolean hasNext3 = it.hasNext();
        Employee next3 = it.next();
        boolean hasNext4 = it.hasNext();
        Employee next4 = it.next();
        //Then
        assertTrue(hasNext1);
        assertEquals(emp1, next1);
        assertTrue(hasNext2);
        assertEquals(emp2, next2);
        assertTrue(hasNext3);
        assertEquals(emp3, next3);
        assertFalse(hasNext4);
        assertNull(next4);
        
    }

}
