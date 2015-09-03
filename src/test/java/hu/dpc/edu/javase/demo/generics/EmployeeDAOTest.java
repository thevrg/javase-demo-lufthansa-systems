/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.dpc.edu.javase.demo.generics;

import hu.dpc.edu.javase.demo.Employee;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author U122951
 */
public class EmployeeDAOTest {
    
    public EmployeeDAOTest() {
    }

    @Test
    public void testSomeMethod() {
        
        EmployeeDAO dao = new EmployeeDAO();
        
        Employee emp = dao.createNew();
        emp.setName("Bela");
    
        
        dao.persist(emp);
        Employee emp2 = dao.findById(emp.getId());
        
        assertEquals(emp, emp2);
    }
    
}
