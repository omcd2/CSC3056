package org.jfree.data.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class CentralValue {

    @Test
    public void testGetCentralValue() {
        // Create an instance of the class that contains the getCentralValue method
        CentralValue calculator = new CentralValue();

        // Test Case 1: Test a scenario where the central value is calculated based on parameters
        double expectedValue1 = 3.5 * 10 + "example".length(); // Expected central value for parameters (3.5, 10, "example")
        double actualValue1 = calculator.getCentralValue(3.5, 10, "example");
        assertEquals(expectedValue1, actualValue1, 0.001); // Assuming a tolerance of 0.001 for double comparison

        // Test Case 2: Test another scenario where the central value is calculated based on parameters
        double expectedValue2 = 2.0 * 20 + "test".length(); // Expected central value for parameters (2.0, 20, "test")
        double actualValue2 = calculator.getCentralValue(2.0, 20, "test");
        assertEquals(expectedValue2, actualValue2, 0.001); // Assuming a tolerance of 0.001 for double comparison
    }

    // This method now accepts parameters to calculate the central value
    public double getCentralValue(double parameter1, int parameter2, String parameter3) {
        // Use the parameters to calculate or determine the central value
        // For demonstration purposes, let's just return a value based on the parameters
        double centralValue = parameter1 * parameter2 + parameter3.length();
        return centralValue;
    }
}
