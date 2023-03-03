package org.jfree.data;

import static org.junit.Assert.*; 
import org.jfree.data.DataUtilities;
import org.jfree.data.KeyedValues;
import org.jmock.*;
import org.junit.*;
import java.util.ArrayList;

//These tests are for the getCumulativePercentages method in DataUtilities.

//Author: Jonathan 

// public static KeyedValues getCumulativePercentages(KeyedValues data)
// Returns a KeyedValues instance that contains the cumulative percentage values for the data in another KeyedValues instance. The cumulative percentage is each value's 
// cumulative sum's portion of the sum of all the values.
// Parameters:
//  data - the data (null not permitted).
// Returns:
//  The cumulative percentages.
// Throws:
//  InvalidParameterException - if invalid data object is passed in.

public class DataUtilities_CumulativePercentage {

	private KeyedValues values;
	
    @Before
    public void setUp() throws Exception { 
	    Mockery mockingContext = new Mockery();
	    values = mockingContext.mock(KeyedValues.class);
		ArrayList<Integer> keys = new ArrayList<Integer>();  
		keys.add(0);
		keys.add(1);
		keys.add(2);
	    mockingContext.checking(new Expectations() {
	        {
	        	//getItemCount
	        	allowing(values).getItemCount();
	        	will(returnValue(3));
	        	allowing(values).getItemCount();
	        	will(returnValue(3));
				// getKeys
                allowing(values).getKeys();
				will(returnValue(keys));
				
				//getIndex
				allowing(values).getIndex(0);
				will(returnValue(0));
				allowing(values).getIndex(1);
				will(returnValue(1));
				allowing(values).getIndex(2);
				will(returnValue(2));

				//getValue
				allowing(values).getValue(0);
				will(returnValue(5));
				allowing(values).getValue(1);
				will(returnValue(9));
				allowing(values).getValue(2);
				will(returnValue(2));


				//getKey
				allowing(values).getKey(0);
				will(returnValue(0));
				allowing(values).getKey(1);
				will(returnValue(1));
				allowing(values).getKey(2);
				will(returnValue(2));
	        }
	    });
    }




	//This test is for verifying the cumulative average object has the same keys as the one passed in.
	@Test 
   	public void getCumulativePercentages_checkKeys() {
    	KeyedValues result = DataUtilities.getCumulativePercentages(values);
    	assertEquals("Resulting keys is", result.getKeys(), values.getKeys());
    }

	//This test is for verifying the cumulative average found is accurate and between 0:1 for the first value. Expected sum is 0.3125 (5/16)
	@Test 
   	public void getCumulativePercentages_firstValue() {
    	KeyedValues result = DataUtilities.getCumulativePercentages(values);
		assertEquals("Cumulative percentage for element 0 is", 0.3125, result.getValue(result.getKey(0)));
    }

	//This test is for verifying the cumulative average found is accurate for the last value is 1.0 (16/16)
	@Test
   	public void getCumulativePercentages_lastValue() {
    	KeyedValues result = DataUtilities.getCumulativePercentages(values);
		assertEquals("Cumulative percentage for element 2 is", 1.0, result.getValue(result.getKey(result.getKeys().size()-1)));
    }
	
	 //This test is for a null object passed in for the first parameter. Expected to throw IllegalArgumentException.
	@Test (expected = IllegalArgumentException.class)
	public void getCumulativePercentages_nullDataObject() {
		DataUtilities.getCumulativePercentages(null);
	}
	
	//This test is to test that no exceptions are thrown when getValue returns null
	@Test 
   	public void getCumulativePercentages_getValueNull() {
	    Mockery mockingContext = new Mockery();
	    values = mockingContext.mock(KeyedValues.class);
		ArrayList<Integer> keys = new ArrayList<Integer>();  
		keys.add(0);
		keys.add(1);
		keys.add(2);
	    mockingContext.checking(new Expectations() {
	        {
	        	//getItemCount
	        	allowing(values).getItemCount();
	        	will(returnValue(3));
	        	allowing(values).getItemCount();
	        	will(returnValue(3));
				// getKeys
                allowing(values).getKeys();
				will(returnValue(keys));
				
				//getIndex
				allowing(values).getIndex(0);
				will(returnValue(0));
				allowing(values).getIndex(1);
				will(returnValue(1));
				allowing(values).getIndex(2);
				will(returnValue(2));

				//getValue
				allowing(values).getValue(0);
				will(returnValue(null));
				allowing(values).getValue(1);
				will(returnValue(null));
				allowing(values).getValue(2);
				will(returnValue(null));

				//getKey
				allowing(values).getKey(0);
				will(returnValue(0));
				allowing(values).getKey(1);
				will(returnValue(1));
				allowing(values).getKey(2);
				will(returnValue(2));
	        }
	    });
    	KeyedValues result = DataUtilities.getCumulativePercentages(values);
		assertEquals("Cumulative percentage for element 0 is", Double.NaN, result.getValue(0));
		assertEquals("Cumulative percentage for element 1 is", Double.NaN, result.getValue(1));
		assertEquals("Cumulative percentage for element 2 is", Double.NaN, result.getValue(2));
    }
	
}