package hu.dpc.edu.javase.demo.zoo;

/**
 *
 * @author u122951
 */
public class Cat extends Animal implements Pet {

    private String name;

    public Cat() {
    }

    public Cat(String name) {
        this.name = name;
    }

    @Override
    public void eat() {
        System.out.println("Cat eats mice.");
    }

    @Override
    public String getName() {
        return name;
    }
}
