package hu.dpc.edu.javase.demo;

import java.io.PrintStream;
import org.junit.Test;
import static org.junit.Assert.*;
import org.mockito.InOrder;
import static org.mockito.Mockito.*;
import org.mockito.internal.verification.VerificationModeFactory;

/**
 *
 * @author u122951
 */
public class EmployeePrinterTest {

    /**
     * Test of printEmployees method, of class EmployeePrinter.
     */
    @Test
    public void testPrintEmployees() {
        //Given
        Employee emp1 = mock(Employee.class);
        Employee emp2 = mock(Employee.class);
        Employee emp3 = mock(Employee.class);
        PrintStream out = mock(PrintStream.class);
        EmployeeIterator mockIterator = mock(EmployeeIterator.class);
        when(mockIterator.hasNext()).thenReturn(true, true, true, false);
        when(mockIterator.next()).thenReturn(emp1, emp2, emp3, null);
        
        EmployeePrinter cut = new EmployeePrinter(out);
        
        //When
        cut.printEmployees(mockIterator);
        
        //Then
        InOrder order = inOrder(mockIterator);
        order.verify(mockIterator).hasNext();
        order.verify(mockIterator).next();
        order.verify(mockIterator).hasNext();
        order.verify(mockIterator).next();
        order.verify(mockIterator).hasNext();
        order.verify(mockIterator).next();
        order.verify(mockIterator).hasNext();
        order.verifyNoMoreInteractions();
        
        InOrder outOrder = inOrder(out);
        outOrder.verify(out).println(emp1);
        outOrder.verify(out).println(emp2);
        outOrder.verify(out).println(emp3);
        outOrder.verifyNoMoreInteractions();
        
        //verify(out, VerificationModeFactory.times(3)).println(any(Employee.class));
        //verify(mockIterator, VerificationModeFactory.times(4)).hasNext();
        //verify(mockIterator, VerificationModeFactory.times(3)).next();
    }
    
}
