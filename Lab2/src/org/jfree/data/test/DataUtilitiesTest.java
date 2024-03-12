package org.jfree.data.test;

import static org.junit.Assert.assertEquals;

import org.jfree.data.DataUtilities;
import org.jfree.data.DefaultKeyedValues;
import org.jfree.data.DefaultKeyedValues2D;
import org.jfree.data.Values2D;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import junit.framework.TestCase;

public class DataUtilitiesTest extends TestCase {
	private Values2D values2D;
	
	@Before
	public void setUp() {
		DefaultKeyedValues2D testValues = new DefaultKeyedValues2D();
		values2D = testValues;
		testValues.addValue(1, 0, 0);
		testValues.addValue(4, 1, 0);
		}
	
	@After
	public void tearDown() 
	{
		values2D = null;
	}
	
	@Test
	public void testValidDataAndColumnColumnTotal()
	 {
	 assertEquals("Wrong sum returned. It should be 5.0",
			 5.0, DataUtilities.calculateColumnTotal(values2D, 0), 0.0000001d);
	 } 
	
	public void testNullDataColumnTotal()
	{
		try
		{
			DataUtilities.calculateColumnTotal(null, 0);
			fail("No exception thrown");
		}
		catch (Exception e)
		{
			assertTrue("Incorrect exception type thrown",
					e.getClass().equals(InvaildParameterException.class));
		}
	}
	public void testgetCumulativePercentages() {
		// setup
		
		DefaultKeyedValues keyvalues = new DefaultKeyedValues();
		keyvalues.addValue((Comparable)0.0,  6.0);
		keyvalues.addValue((Comparable)1.0,  11.0);
		keyvalues.addValue((Comparable)2.0,  3.0);
		KeyedValues object_under_test = (KeyedValues) DataUtilities.getCumulativePercentages((org.jfree.data.KeyedValues) keyvalues);
		
		assertEquals((double) object_under_test.getValue(2), 1.0, .000000001d);
 }
}

