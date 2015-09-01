package hu.dpc.edu.javase.demo;

/**
 * Na ez itt az elso osztalyom
 *
 * @author vrg
 */
public class Hello {
    /**
     * Ez itt a main metodus...
     * Na es majd ez meghivja a {@link Masik#hello() } metodust.
     * @param args Ide jonnnek a parameterek argumentumok
     */
    public static void main(String[] args) {
        System.out.println("Hello");
        System.out.println("World");
        hu.dpc.edu.javase.demo.Masik.hello();
    }
}
