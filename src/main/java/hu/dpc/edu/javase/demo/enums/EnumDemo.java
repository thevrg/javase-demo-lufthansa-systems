/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.dpc.edu.javase.demo.enums;

/**
 *
 * @author u122951
 */
public class EnumDemo {
    public static void main(String[] args) {
        Season s = Season.AUTUMN;
        System.out.println("s: " + s.getDisplayName());
        switch(s) {
            case AUTUMN:
                System.out.println("Osz van");
        }
        
        Season[] seasons = Season.values();
        
        for (Season season : seasons) {
            System.out.println(season.getDisplayName());
        }
    }
}
