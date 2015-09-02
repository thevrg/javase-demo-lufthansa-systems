/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.dpc.edu.javase.demo.nested;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;

/**
 *
 * @author u122951
 */
public class MyGUI {
    private JFrame  frame;
    private JButton ok;
    

    public MyGUI() {
        frame = new JFrame("Hello");
        ok = new JButton("OK");
        
        ok.addActionListener(new LoggerActionListener());
        ok.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                ok.setBackground(Color.red);
            }
        });
        
        frame.getContentPane().add(ok);
    }
    
    
    
    public void show() {
        frame.pack();
        frame.setVisible(true);
    }
    
    public static void main(String[] args) {
        MyGUI myGUI = new MyGUI();
        myGUI.show();
    }
}
