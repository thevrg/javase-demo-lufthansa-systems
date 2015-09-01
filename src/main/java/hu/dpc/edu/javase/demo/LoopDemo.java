package hu.dpc.edu.javase.demo;

/**
 *
 * @author u122951
 */
public class LoopDemo {
    public static void main(String[] args) {
        akarmi: 
        for(int i = 0; i < 10; i++ ) {
            
            for(int j = 0; j < 10; j++ ) {
                continue akarmi;
            }
        }
    }
    
}
