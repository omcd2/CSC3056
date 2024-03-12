package org.jfree.data.test;
 
import static org.junit.Assert.*;
 
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
 
public class NumberArrayTest {
 
    private int[] numbers;
 
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
        numbers = new int[]{1, 2, 3, 4, 5};
    }
 
    @After
    public void tearDown() throws Exception {
        // Clean up resources after each test method is run
        numbers = null;
    }
 
    @Test
    public void testArrayLength() {
        // Test the length of the number array
        assertEquals(5, numbers.length);
    }
 
    @Test
    public void testArrayElements() {
        // Test individual elements of the number array
        assertEquals(1, numbers[0]);
        assertEquals(2, numbers[1]);
        assertEquals(3, numbers[2]);
        assertEquals(4, numbers[3]);
        assertEquals(5, numbers[4]);
    }
 
    @Test
    public void testSum() {
        // Test the sum of all elements in the number array
        int sum = 0;
        for (int number : numbers) {
            sum += number;
        }
        assertEquals(15, sum);
    }
 
    @Test
    public void testContainsElement() {
        // Test if the number array contains a specific element
        assertTrue(containsElement(numbers, 3));
        assertFalse(containsElement(numbers, 6));
    }
 
    private boolean containsElement(int[] array, int element) {
        // Helper method to check if the array contains a specific element
        for (int num : array) {
            if (num == element) {
                return true;
            }
        }
        return false;
    }
}