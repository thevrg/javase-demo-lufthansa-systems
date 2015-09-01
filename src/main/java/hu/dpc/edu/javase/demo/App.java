package hu.dpc.edu.javase.demo;

/**
 *
 * @author vrg
 */
public class App {
    public static void main(String[] args) {
        System.out.println("Starting App");
        Object e = new Manager(111L, "Bela", 11111, "HR");
        System.out.println("e: " + e);
    }
}
