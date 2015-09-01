
package hu.dpc.edu.javase.demo.zoo;

/**
 *
 * @author u122951
 */
public class Spider extends Animal implements Pet{

    @Override
    public void eat() {
        System.out.println("Spider eats flies.");
    }
    
    public String getName() {
        return "My Spider";
    }
}
