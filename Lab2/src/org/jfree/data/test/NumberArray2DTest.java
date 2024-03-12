package org.jfree.data.test;
 
import static org.junit.Assert.*;
 
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
 
public class NumberArray2DTest {
 
    private int[][] numbers;
 
    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        // Executed once before any test methods are run
    }
 
    @AfterClass
    public static void tearDownAfterClass() throws Exception {
        // Executed once after all test methods have been run
    }
 
    @Before
    public void setUp() throws Exception {
        // Initialize common resources needed by test methods
        numbers = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
    }
 
    @After
    public void tearDown() throws Exception {
        // Clean up resources after each test method is run
        numbers = null;
    }
 
    @Test
    public void testArrayDimensions() {
        // Test the dimensions of the 2D number array
        assertEquals(3, numbers.length); // Number of rows
        assertEquals(3, numbers[0].length); // Number of columns
    }
 
    @Test
    public void testArrayElements() {
        // Test individual elements of the 2D number array
        assertEquals(1, numbers[0][0]);
        assertEquals(2, numbers[0][1]);
        assertEquals(3, numbers[0][2]);
        assertEquals(4, numbers[1][0]);
        assertEquals(5, numbers[1][1]);
        assertEquals(6, numbers[1][2]);
        assertEquals(7, numbers[2][0]);
        assertEquals(8, numbers[2][1]);
        assertEquals(9, numbers[2][2]);
    }
 
    @Test
    public void testSum() {
        // Test the sum of all elements in the 2D number array
        int sum = 0;
        for (int[] row : numbers) {
            for (int number : row) {
                sum += number;
            }
        }
        assertEquals(45, sum);
    }
}