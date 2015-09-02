
package hu.dpc.edu.javase.demo.nested;

import hu.dpc.edu.javase.demo.zoo.Dog;
import hu.dpc.edu.javase.demo.zoo.Pet;

/**
 *
 * @author u122951
 */
public class Outer {
    private String name;

    public Outer(String name) {
        this.name = name;
    }

    public static class Nested {
        private String name;

        public void setName(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }
        
    }
    
    public Inner createInner(String name) {
        return new Inner(name);
    }
    
    public class Inner {

        private String name;

        public Inner(String name) {
            this.name = name;
        }
        
        public String toString() {
            return "name: " + Outer.this.name + ", this.name: " + this.name;
        }
        
    }
    
    public Pet createLocal(final String name) {
        
        final int szam = (int) (Math.random() * 1000);
        
        class MyLocalPet implements Pet {

            @Override
            public String getName() {
                return "My name is " + name + ", I am in " + Outer.this.name + ", szam = " + szam;
            }

            @Override
            public String toString() {
                return "Outer.this.name: " + Outer.this.name + ", this.name: " + name;
            } 
        }
        
        return new MyLocalPet();
    }
    
     public Pet createAnonymous(final String name) {
        
        final int szam = (int) (Math.random() * 1000);
        
        return new Dog("dog " + name) {

            @Override
            public String getName() {
                return "My name is anonymous " + name + ", I am in " + Outer.this.name + ", szam = " + szam + "super.getnName: " + super.getName();
            }

            @Override
            public String toString() {
                return "Outer.this.name: " + Outer.this.name + ", this.name: " + name;
            } 
        };
    }
}
