package hu.dpc.edu.javase.demo.exception;

/**
 *
 * @author u122951
 */
public class FinallyDemo {

    private static int hello(String alma) {
        try {
            try {
                if ("A".equals(alma)) {
                    throw new RuntimeException("Hajjajj");
                } else {
                    return 124;
                }
            } finally {
                System.out.println("hello(" + alma + ") finally.. ");
                throw new IllegalStateException("haha finally");
            }
        } finally {
            return 999;
        }
    }

    public static void main(String[] args) {
        System.out.println("alma: " + hello("122"));
        System.out.println("alma: " + hello("A"));
    }
}
