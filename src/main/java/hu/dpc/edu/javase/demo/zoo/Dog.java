
package hu.dpc.edu.javase.demo.zoo;

/**
 *
 * @author u122951
 */
public class Dog extends Animal implements Pet{

    private String name;

    public Dog(String name) {
        this.name = name;
    }
    
    
    
    @Override
    public void eat() {
        System.out.println("Dog eats dog food.");
    }

    @Override
    public String getName() {
        return name;
    }
    
}
