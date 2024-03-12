package org.jfree.data.test;
 
import org.junit.Test;
import static org.junit.Assert.*;
 
import java.awt.Rectangle;
 
public class GetWidth {
 
    @Test
    public void testGetWidth() {
        // Create a rectangle with width 5 and height 4
        Rectangle rectangle = new Rectangle(5, 4);
 
        // Test the getWidth() method
        double expectedWidth = 5.0;
        double actualWidth = rectangle.getWidth();
        assertEquals(expectedWidth, actualWidth, 0.001); // Provide a delta value for double comparison
    }
}