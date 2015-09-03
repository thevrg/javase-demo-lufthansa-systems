package hu.dpc.edu.javase.demo;

/**
 *
 * @author u122951
 */
public interface EmployeeIterator {
    
    /**
     * 
     * @return
     * @throws IllegalStateException thrown if the underlying Employee collection
     * is changed after the creation of the iterator.
     */
    public boolean hasNext() throws IllegalStateException;
    /**
     * 
     * @return
     * @throws IllegalStateException thrown if there are no more elements or if
     * the underlying Employee collection is changed after the creation of the
     * iterator.
     */
    public Employee next() throws IllegalStateException;
    
}
