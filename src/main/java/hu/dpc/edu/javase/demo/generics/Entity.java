package hu.dpc.edu.javase.demo.generics;

import java.io.Serializable;

/**
 *
 * @author U122951
 */
public interface Entity<ID extends Serializable> {
    public ID getId();
}
