package hu.dpc.edu.javase.demo.zoo;

/**
 *
 * @author u122951
 */
public class ZooDemo {

    public static void main(String[] args) {
        Cat c1 = new Cat("Lukrecia");
        Dog d1 = new Dog("Frakk");
        Spider s1 = new Spider();

        Animal a1 = c1;

        //Dog d2 = (Dog) c1;
        Pet p = (Pet)a1;
        
        Pet p2 = (Pet)s1;
        System.out.println("p.name: " +  p.getName());
    }
}
