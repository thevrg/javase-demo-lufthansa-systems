package hu.dpc.edu.javase.demo.wrappers;

/**
 *
 * @author u122951
 */
public class WrapperDemo {
    public static void main(String[] args) {
        Integer i = 122;
        Number n = i;
        Long l1 = Long.valueOf(127L);
        Integer i2 = Integer.valueOf(128);
        
        int i3 = i2;
        System.out.println("i2 : " + i2);
        System.out.println("i3 : " + i3);
        
        if (i == i2) {
            System.out.println("i == i2");
        } else {
            System.out.println("i != i2");
        }
        
        Object o = (short)23;
        
        if (i.intValue() < 2) {
            System.out.println("i < 2");
        }
        
        System.out.println("o.class.name: " + o.getClass().getName());
     
        //a1, a2
        
        double a1 = Double.NaN;
        double a2 = 2/0D;
        if (Double.isNaN(a1)) {
            System.out.println("Never prints");
        }
        
        int parsedInt = Integer.parseInt("1023");
        System.out.println("parsed: " + parsedInt);
        int num = Integer.MIN_VALUE;
        int abs = Math.abs(num);
        System.out.println("abs: " + abs);
        if (num != 0 && num == abs) {
            System.out.println("never...");
        }
        System.out.println();
    }
}
