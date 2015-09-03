/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.dpc.edu.javase.demo.annotations;

import hu.dpc.edu.javase.demo.Employee;
import java.util.List;

/**
 *
 * @author U122951
 */
public interface EmployeeService {
    @RolesAllowed(value = {Role.ADMIN, Role.MANAGER}, description = "Na ez itt a description")
    public void addEmployee(Employee emp);
    
    @RolesAllowed(Role.USER)
    public Employee findById(Long id);
    
    public List<Employee> findAll();
}
