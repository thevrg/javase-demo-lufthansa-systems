/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.dpc.edu.javase.demo.nested;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author u122951
 */
public class LoggerActionListener implements ActionListener{

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("Action perfmed: " + e.getActionCommand());
    }
    
}
