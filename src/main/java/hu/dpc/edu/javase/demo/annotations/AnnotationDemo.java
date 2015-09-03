/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.dpc.edu.javase.demo.annotations;

import java.lang.reflect.Method;

/**
 *
 * @author U122951
 */
public class AnnotationDemo {
    
    public static void getInfo(Class type) {
        Method[] declaredMethods = type.getDeclaredMethods();
        for (Method method : declaredMethods) {
            System.out.println("found method: " + method);
            RolesAllowed rolesAllowed = method.getAnnotation(RolesAllowed.class);
            if (rolesAllowed != null) {
                System.out.println("rolesAllowed.getClass: " + rolesAllowed.getClass());
                System.out.println("desc: " + rolesAllowed.description());
                for (Role value : rolesAllowed.value()) {
                    System.out.println("allowed role: " + value);
                }
            }
        }
    }
    
    public static void main(String[] args) {
        getInfo(EmployeeService.class);
    }
}
