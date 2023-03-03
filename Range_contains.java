package org.jfree.data;

import static org.junit.Assert.*; 
import org.jfree.data.Range; 
import org.junit.*;


//These tests are for the contains method in Range.

//Author: Jonathan

public class Range_contains {

    private Range range; 

    @Before
    public void setUp() throws Exception { 
        range = new Range(-100, 100);
    }

// ==================================================================== contains ============================================================================
// public boolean contains(double value)
// Returns true if the specified value is within the range and false otherwise.
// Parameters:
// value - the value to be tested
// Returns:
// true if the range contains the specified value.

    //This test is for ensuring the function includes the beginning of the range 
	@Test 
    public void contains_frontRange() {
        boolean result = range.contains(-100);
    	assertEquals("Does the range contain -100:",  true, result);
    }
    
    //This test is for ensuring the function includes the end of the range 
    @Test
    public void contains_endRange() {
        boolean result = range.contains(100);
    	assertEquals("Does the range contain 100:",  true, result);
    }
    
    //This test is for ensuring the function works with positive numbers 
    @Test
    public void contains_betweenRangePositive() {
        boolean result = range.contains(50);
    	assertEquals("Does the range contain 50:",  true, result);
    }
    
    //This test is for ensuring the function works with negative numbers 
    @Test
    public void contains_betweenRangeNegative() {
        boolean result = range.contains(-50);
    	assertEquals("Does the range contain -50:",  true, result);
    }
    
    //This test is for ensuring the function cannot find positive numbers out of range
    @Test
    public void contains_outRangePositive() {
        boolean result = range.contains(500);
        assertEquals("Does the range contain 500:",  false, result);
    }
    
    //This test is for ensuring the function cannot find negative numbers out of range
    @Test
    public void contains_outRangeNegative() {
        boolean result = range.contains(-500);
    	assertEquals("Does the range contain -500:",  false, result);
    }
    
    //This test is for ensuring the function can find decimal numbers within range
    @Test
    public void contains_withinRangeDecimal() {
    	boolean result = range.contains(0.12345);
    	assertEquals("The range contains 0.12345:",  true, result);
    }
}
    
