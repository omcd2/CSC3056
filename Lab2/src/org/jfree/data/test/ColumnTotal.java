package org.jfree.data.test;


import static org.junit.Assert.assertEquals;

import org.jfree.data.DataUtilities;
import org.jfree.data.DefaultKeyedValues;
import org.jfree.data.DefaultKeyedValues2D;
import org.jfree.data.Values2D;
import org.junit.Test;
 
public class ColumnTotal {
 
    @Test
    public void testCalculateColumnTotal() {
        // Create a sample dataset
        DefaultKeyedValues dataset = new DefaultKeyedValues();
        dataset.addValue("A", 10);
        dataset.addValue("B", 20);
        dataset.addValue("C", 30);
 
        // Convert the DefaultKeyedValues to Values2D
        Values2D values2D = new DefaultKeyedValues2D();
        for (int i = 0; i < dataset.getItemCount(); i++) {
            ((DefaultKeyedValues2D) values2D).addValue(dataset.getValue(i), 0, dataset.getKey(i));
        }
 
        // Calculate the expected total
        double expectedTotal = 10 + 20 + 30;
 
        // Call the method to be tested
        double actualTotal = DataUtilities.calculateColumnTotal(values2D, 0);
 
        // Check if the actual total matches the expected total
        assertEquals(expectedTotal, actualTotal, 0.0001); // Provide a delta value for double comparison
    }
}
