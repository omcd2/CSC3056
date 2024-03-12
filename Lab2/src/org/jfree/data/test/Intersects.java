package org.jfree.data.test;

import org.junit.Test;
import static org.junit.Assert.*;

public class Intersects {

    @Test
    public void testIntersects() {
        // Create an instance of the class that contains the intersects method
        Intersects lineSegment = new Intersects();

        // Test Case 1: Test when the line segments intersect
        double startX1 = 0.0;
        double endX1 = 5.0;
        double startX2 = 3.0;
        double endX2 = 8.0;
        boolean expectedResult1 = true;
        boolean actualResult1 = lineSegment.intersects(startX1, endX1, startX2, endX2);
        assertTrue(actualResult1);

        // Test Case 2: Test when the line segments do not intersect
        double startX3 = 0.0;
        double endX3 = 5.0;
        double startX4 = 6.0;
        double endX4 = 8.0;
        boolean expectedResult2 = false;
        boolean actualResult2 = lineSegment.intersects(startX3, endX3, startX4, endX4);
        assertFalse(actualResult2);
    }

    private boolean intersects(double startX1, double endX1, double startX2, double endX2) {
        // Check if the line segments intersect
        // Two line segments intersect if one starts before the other ends, and vice versa
        return (startX1 <= endX2 && startX2 <= endX1);
    }
}
