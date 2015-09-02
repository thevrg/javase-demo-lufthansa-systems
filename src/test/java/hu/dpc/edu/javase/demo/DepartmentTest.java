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

    @Test(expected = IndexOutOfBoundsException.class)
    public void testGetEmployeeShouldThrowIndexOutOfBoundsExceptionForNegativeIndexValues() {
        //Given
        Department dep = createHRDepartmentWithThreeEmployees();
        //When
        Employee getEmpMinusOneResult = dep.getEmployee(-1);
    }

    @Test
    public void testGetEmployeeReturnsNullForNonExistingIndexValues() {
        //Given
        Department dep = createHRDepartmentWithThreeEmployees();
        //When
        Throwable getEmployee3Exception = null;
        Throwable getEmployee1000Exception = null;
                
        try {
            dep.getEmployee(3);
        } catch (Throwable t) {
            getEmployee3Exception = t;
        }
        try {
            dep.getEmployee(1000);
        } catch (Throwable t) {
            getEmployee1000Exception = t;
        }
        
        //Then
        assertNotNull(getEmployee3Exception);
        assertTrue(getEmployee3Exception instanceof IndexOutOfBoundsException);
        assertNotNull(getEmployee1000Exception);
        assertTrue(getEmployee1000Exception instanceof IndexOutOfBoundsException);
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
    @Test(expected = IndexOutOfBoundsException.class)
    public void testRemoveEmployee_int_ShouldThrowIndexOutOfBoundsExceptionWhenIndexIsNegative() {
        //Given
        Department dep = createHRDepartmentWithThreeEmployees();
        //When
        dep.removeEmployee(-1);
    }

    /**
     * Test of removeEmployee method, of class Department.
     */
    @Test(expected = IndexOutOfBoundsException.class)
    public void testRemoveEmployee_int_ShouldThrowIndexOutOfBoundsExceptionWhenIndexIsNegative2() {
        //Given
        Department dep = createHRDepartmentWithThreeEmployees();
        //When
        dep.removeEmployee(-100);
    }

    /**
     * Test of removeEmployee method, of class Department.
     */
    @Test
    public void testRemoveEmployee_int_ShouldThrowIndexOutOfBoundsExceptionWhenIndexIsNotValid() {
        //Given
        Department dep = createHRDepartmentWithThreeEmployees();
        //When
        try {
            dep.removeEmployee(3);
            fail("IndexOutOfBoundsException is expected here, but no exception was thrown");
        } catch (IndexOutOfBoundsException ex) {
            //expected
        } catch (AssertionError ex) {
            throw ex; // transparently let the assertion error fall through
        } catch (Throwable t) {
            throw new AssertionError("Unexpected exception", t);
        }

        try {
            dep.removeEmployee(300);
            fail("IndexOutOfBoundsException is expected here, but no exception was thrown");
        } catch (IndexOutOfBoundsException ex) {
            //expected
        } catch (AssertionError ex) {
            throw ex; // transparently let the assertion error fall through
        } catch (Throwable t) {
            throw new AssertionError("Unexpected exception", t);
        }

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
        
        Throwable exception4 = null;
        try {
            it.next(); //fourth invocation
        } catch (Throwable t) {
            exception4 = t;
        }
        
        //Then
        assertTrue(hasNext1);
        assertEquals(emp1, next1);
        assertTrue(hasNext2);
        assertEquals(emp2, next2);
        assertTrue(hasNext3);
        assertEquals(emp3, next3);
        assertFalse(hasNext4);
        assertNotNull("next() should throw an exception at the fourth invocation", exception4);
        assertTrue("next() should throw an IllegalStateException at the fourth invocation, but it threw this: " + exception4,
                exception4 instanceof IllegalStateException);

    }

}
