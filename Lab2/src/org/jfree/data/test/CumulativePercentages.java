package org.jfree.data.test;

import org.jfree.data.DefaultKeyedValues;
import org.jfree.data.KeyedValues;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class CumulativePercentages {

    @Test
    public void testGetCumulativePercentages() {
        // Test Case 1: Empty KeyedValues object
        KeyedValues emptyData = new DefaultKeyedValues();
        assertNull(CumulativePercentages.getCumulativePercentages(emptyData));

        // Test Case 2: Non-empty KeyedValues object (positive values)
        KeyedValues positiveData = new DefaultKeyedValues();
        ((DefaultKeyedValues) positiveData).addValue("A", 10.0);
        ((DefaultKeyedValues) positiveData).addValue("B", 20.0);
        ((DefaultKeyedValues) positiveData).addValue("C", 30.0);
        KeyedValues expectedPositiveResult = new DefaultKeyedValues();
        ((DefaultKeyedValues) expectedPositiveResult).addValue("A", 16.666666666666668);
        ((DefaultKeyedValues) expectedPositiveResult).addValue("B", 50.0);
        ((DefaultKeyedValues) expectedPositiveResult).addValue("C", 100.0);
        KeyedValues resultPositive = CumulativePercentages.getCumulativePercentages(positiveData);
        assertKeyedValuesEquals(expectedPositiveResult, resultPositive);

        // Test Case 3: Non-empty KeyedValues object (negative values)
        KeyedValues negativeData = new DefaultKeyedValues();
        ((DefaultKeyedValues) negativeData).addValue("X", -10.0);
        ((DefaultKeyedValues) negativeData).addValue("Y", -20.0);
        ((DefaultKeyedValues) negativeData).addValue("Z", -30.0);
        assertNull(CumulativePercentages.getCumulativePercentages(negativeData));

        // Test Case 4: Non-empty KeyedValues object (mix of positive and negative values)
        KeyedValues mixData = new DefaultKeyedValues();
        ((DefaultKeyedValues) mixData).addValue("P", 10.0);
        ((DefaultKeyedValues) mixData).addValue("Q", -20.0);
        ((DefaultKeyedValues) mixData).addValue("R", 30.0);
        assertNull(CumulativePercentages.getCumulativePercentages(mixData));

        // Test Case 5: Non-empty KeyedValues object (non-numeric values)
        KeyedValues nonNumericData = new DefaultKeyedValues();
        ((DefaultKeyedValues) nonNumericData).addValue("alpha", 10.0);
        ((DefaultKeyedValues) nonNumericData).addValue("beta", 20.0);
        ((DefaultKeyedValues) nonNumericData).addValue("gamma", 30.0);
        assertNull(CumulativePercentages.getCumulativePercentages(nonNumericData));
    }

    public static KeyedValues getCumulativePercentages(KeyedValues data) {
            // Check if the provided KeyedValues object is null or empty
            if (data == null || data.getItemCount() == 0) {
                return null; // Return null for empty input
            }

            DefaultKeyedValues cumulativePercentages = new DefaultKeyedValues();
            double total = calculateTotal(data);

            double cumulativePercentage = 0.0;
            for (int i = 0; i < data.getItemCount(); i++) {
                Comparable<?> key = data.getKey(i);
                Number value = data.getValue(i);
                double percentage = value.doubleValue() / total * 100.0;
                cumulativePercentage += percentage;
                cumulativePercentages.addValue(key, cumulativePercentage);
            }

            return cumulativePercentages;
        }

        private static double calculateTotal(KeyedValues data) {
            double total = 0.0;
            for (int i = 0; i < data.getItemCount(); i++) {
                total += data.getValue(i).doubleValue();
            }
            return total;
    }

    private void assertKeyedValuesEquals(KeyedValues expected, KeyedValues actual) {
        assertEquals(expected.getItemCount(), actual.getItemCount());
        for (int i = 0; i < expected.getItemCount(); i++) {
            assertEquals(expected.getKey(i), actual.getKey(i));
            assertEquals(expected.getValue(i), actual.getValue(i));
        }
    }
}




