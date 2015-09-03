package hu.dpc.edu.javase.demo.generics;

/**
 *
 * @author U122951
 */
public class Csoda {

    public static <T> T cast(Object o) {
        return (T) o;
    }
}
