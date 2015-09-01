/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.dpc.edu.javase.demo;

/**
 *
 * @author u122951
 */
public abstract class MyBaseClass {

    protected abstract void getAttributeValues(StringBuilder sb);

    @Override
    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName()).append("{");
        getAttributeValues(sb);
        sb.append("}");
        return sb.toString();
    }
    
}
