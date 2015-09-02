
package hu.dpc.edu.javase.demo.exception;

/**
 *
 * @author u122951
 */
public class MyResource implements AutoCloseable{

    private String name;

    public MyResource(String name) {
        this.name = name;
        System.out.println("MyResource " + name + "created");
    }
    
    @Override
    public void close() throws RuntimeException, Error {
        System.out.println("closing " + name);
        throw new RuntimeException("Exception during closing " + name);
    }
    
}
