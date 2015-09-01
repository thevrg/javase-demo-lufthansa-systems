
package hu.dpc.edu.javase.demo.enums;

/**
 *
 * @author u122951
 */
public enum Season {
    WINTER("Tel"),SPRING("Tavasz"),SUMMER("Nyar"),AUTUMN("Osz");
    
    private final String displayName;

    Season(String displayName) {
        this.displayName = displayName;
    }
    
    public String getDisplayName() {
        return displayName;
    }
    
    
}
