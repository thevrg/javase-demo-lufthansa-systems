/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.dpc.edu.javase.demo.exception;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *
 * @author u122951
 */
public class ExceptionDemo {

    public static String readContent(String fileName) throws ContentReadException {
        try {
            Scanner scanner = new Scanner(new File(fileName)).useDelimiter("[\r\n]+");
            StringBuilder sb = new StringBuilder();
            while (scanner.hasNext()) {
                String line = scanner.next();
                sb.append(line).append(System.getProperty("line.separator"));
            }

            return sb.toString();
        } catch (FileNotFoundException ex) {
            throw new ContentReadException(fileName, "Invalid filename: " + fileName, ex);
        } finally {
            System.out.println("Na ezt mindenkeppen (readContent)");
        }
    }

    /**
     * 
     * @param numbers
     * @return
     * @throws IllegalArgumentException Thrown if the number of arguments is zero. 
     */
    public static int avg(int... numbers) throws IllegalArgumentException {
        if (numbers.length == 0) {
            throw new IllegalArgumentException("number of numbers must be at least one");
        }
        int sum = 0;
        for (int number : numbers) {
            sum += number;
        }
        return sum / numbers.length;
    }

    public static void main(String[] args) throws FileNotFoundException {
        
        try {
            readContent("pom.xml");
            System.out.println("avg(2,3,4): " + avg(2, 3, 4));
            System.out.println("avg(): " + avg(2));
            System.out.println("ends...");

        } catch (ContentReadException ex) {
            System.out.println("Content read error: " + ex.toString() + "content Id: " + ex.getContentId());
        } catch (ArithmeticException | NullPointerException ex) {
            System.out.println("Kivetel: " + ex.getMessage());
            throw ex;
        } catch (Exception ex) {
            System.err.println("Exception happened");
            ex.printStackTrace();
        } finally {
            System.out.println("na ezt mindenkeppen futtasd");
        }

    }
}
