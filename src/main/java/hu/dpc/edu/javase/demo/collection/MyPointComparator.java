package hu.dpc.edu.javase.demo.collection;

import hu.dpc.edu.javase.demo.serialization.MyPoint;
import java.util.Comparator;

/**
 *
 * @author U122951
 */
public class MyPointComparator implements Comparator<MyPoint>{

    @Override
    public int compare(MyPoint p1, MyPoint p2) {
        return p2.getY() - p1.getY();
    }
    
}
