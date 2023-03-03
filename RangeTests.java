package org.jfree.data;

import static org.junit.Assert.*; 
import org.jfree.data.Range; 
import org.junit.*;


public class RangeTests {
	
	
//Author: Aarushi
//============================================================== getLength() =======================================================
	//This test is for getting the length of the range between two positive integers. Expected length = 5
	@Test 
   	public void getLength_positiveIntegers() {
        Range range= new Range(31,36);
    	double result= range.getLength();
    	assertEquals("Length between 31 and 36 is",  5, result, .000000001d);
    }

    //This test is for getting the length of the range between a negative and positive integer. Expected length = 200
	@Test 
    public void getLength_negativeAndPositiveIntegers() {
     Range range= new Range(-100,100);
     double result= range.getLength();
     assertEquals("Length between -100 and 100 is",  200, result, .000000001d);
 }

    //This test is for getting the length of the range between a negative integer and positive double. Expected length = 440.5
    @Test 
    public void getLength_negativeAndPositiveDoubles() {
    Range range= new Range(-28,440.5);
    double result= range.getLength();
    assertEquals("Length between -28 and 440.5 is",  468.5, result, .000000001d);
    }

    //This test is for getting the length of the range between a large negative and large positive. Expected length = 2000000
    @Test 
    public void getLength_largeNegativeAndPositive() {
    Range range= new Range(-1000000,1000000);
    double result= range.getLength();
    assertEquals("Length between -1000000 and 1000000 is",  2000000, result, .000000001d);
    }
    
    //This test is for getting the length of 0. Expected length = 0
    @Test 
    public void getLength_zero() {
    Range range= new Range(2,2);
    double result= range.getLength();
    assertEquals("Length between 2 and 2 is",  0, result, .000000001d);
    }

    Range brokenRange;
    //This test is for checking that an exception is thrown if the range is invalid
    @Test(expected= Exception.class)
	    public void getLength_invalid() {
    	try {
    		brokenRange = new Range(1,-1);
    	}catch(Exception e) {
    		brokenRange.getLength();
    	}
    }

  //Author: Aarushi
  //============================================================== getCentralValue() =======================================================
    @Test
    public void getCentralValue_zero() {
    	Range range= new Range(-1,1);
        double result= range.getCentralValue();
    	assertEquals("The central value between -1 and 1 is", 0, result, .000000001d);
    	
    }
    
  //Author: Aarushi
  //================================================================== min and max ===============================================================
    
    // The min (double1, double2) and max (double1, double2) functions are private methods in Range. They act as helper methods to the public combineIgnoringNaN() method
    
    //This test will check the min and max functions through the combineIgnoringNaN() function.
    
    @Test
	public void minAndMax_combineIgnoringNaN() {
		double NaN1 = Math.sqrt(-200); // first not-a-number 
		double NaN2 = Math.sqrt(-8); //second not-a-number
		Range range = new Range(0, 8); // valid test range
		Range result = Range.combineIgnoringNaN(range, new Range(NaN1, NaN2)); // will call min and max functions
		assertEquals("The lower bound is", result.getLowerBound(), 0, .000000001d);
		
	}

  //Author: Aarushi
  //================================================================== expand (Range range, double lowerMargin, double upperMargin)  ===============================================================
    
    @Test
	public void expand_marginsWithDecimals() { 
		Range range = new Range(2, 6); 
		Range expandedRange = Range.expand(range, 0.25, 0.5); 

		assertEquals("The lower margin range is", 1, expandedRange.getLowerBound(), .000000001d);
		assertEquals("The upper margin range is", 8, expandedRange.getUpperBound(), .000000001d);
		
    }
    @Test
   	public void expand_marginsWithIntegers() { 
   		Range range = new Range(2, 6); 
   		Range expandedRange = Range.expand(range, 2, 2); 

   		assertEquals("The lower margin range is", 10, expandedRange.getLowerBound(), .000000001d);
   		assertEquals("The upper margin range is", 14, expandedRange.getUpperBound(), .000000001d);
   		
       }
    
    @Test
	public void expand_Zero() {
    	Range range = new Range(2, 6); 
		Range expandedRange = Range.expand(range, 0, 0); 
		
		assertEquals("The lower margin range is", 0, expandedRange.getLowerBound(), .000000001d);
		assertEquals("The upper margin range is", 0, expandedRange.getUpperBound(), .000000001d);
	}
    
    @Test
	public void expand_NegativeRange() {
    	Range range = new Range(-6, -2); 
    	Range expandedRange = Range.expand(range, 0.44, 0.33);
		
    	assertEquals("The upper margin range is", -0.68, expandedRange.getUpperBound(), .000000001d);
		
		
	}
    
    @Test
	public void expand_NegativeMargins() {
    	Range range = new Range(-6, -2); 
    	Range expandedRange = Range.expand(range, -0.29, -0.35);
		
    	assertEquals("The upper margin range is", -3.4, expandedRange.getUpperBound(), .000000001d);
		
		
	}
    
    //Author: Jonathan
    //================================================================== combine ===============================================================
    @Test
    public void combine_valid(){
      Range range1 = new Range(-5,0);
      Range range2 = new Range(0,5);
      Range range = Range.combine(range1, range2);
      assertEquals("The lower range is", -5, range.getLowerBound(), .000000001d);
      assertEquals("The upper range is", 5, range.getUpperBound(), .000000001d);
    }

    @Test
    public void combine_range1Null(){
      Range range1 = null;
      Range range2 = new Range(0,5);
      Range range = Range.combine(range1, range2);
      assertEquals("The lower range is", range2.getLowerBound(), range.getLowerBound(), .000000001d);
      assertEquals("The upper range is", range2.getUpperBound(), range.getUpperBound(), .000000001d);
    }
    
    @Test
    public void combine_range2Null(){
      Range range1 = new Range(0,5);
      Range range2 = null;
      Range range = Range.combine(range1, range2);
      assertEquals("The lower range is", range1.getLowerBound(), range.getLowerBound(), .000000001d);
      assertEquals("The upper range is", range1.getUpperBound(), range.getUpperBound(), .000000001d);
    }
    
    //Author: Jonathan
    //================================================================== combineIgnoringNaN ===============================================================
    @Test 
    public void combineIgnoringNaN_range1Null(){
      Range range1 = null;
      Range range2 = new Range(0,5);
      Range range = Range.combineIgnoringNaN(range1, range2);
      assertEquals("The lower range is", range2.getLowerBound(), range.getLowerBound(), .000000001d);
      assertEquals("The upper range is", range2.getUpperBound(), range.getUpperBound(), .000000001d);
    }

    @Test 
    public void combineIgnoringNaN_range1Null_range2NaN(){
      Range range1 = null;
      Range range2 = new Range(Double.NaN,Double.NaN);
      Range range = Range.combineIgnoringNaN(range1, range2);
      assertNull(range);
    }
    
    @Test
    public void combineIgnoringNaN_range2Null(){
      Range range1 = new Range(0,5);
      Range range2 = null;
      Range range = Range.combineIgnoringNaN(range1, range2);
      assertEquals("The lower range is", range1.getLowerBound(), range.getLowerBound(), .000000001d);
      assertEquals("The upper range is", range1.getUpperBound(), range.getUpperBound(), .000000001d);
    }
    
    @Test 
    public void combineIgnoringNaN_range1NaN_range2Null(){
      Range range1 = new Range(Double.NaN,Double.NaN);
      Range range2 = null;
      Range range = Range.combineIgnoringNaN(range1, range2);
      assertNull(range);
    }

    @Test
    public void combineIgnoringNaN_bothNull(){
      Range range1 = null;
      Range range2 = null;
      Range range = Range.combineIgnoringNaN(range1, range2);
      assertNull(range);
    }
    @Test
    public void combineIgnoringNaN_bothNaN(){
      Range range1 = new Range(Double.NaN,Double.NaN);
      Range range2 = new Range(Double.NaN,Double.NaN);
      Range range = Range.combineIgnoringNaN(range1, range2);
      assertNull(range);
    }
    
    //Author: Jonathan
    //================================================================== scale ===============================================================
    @Test 
    public void scale_positiveFactor(){
      Range range1 = new Range(-10,10);
      Range range = Range.scale(range1,1.1);
      assertEquals("The lower range is", -11, range.getLowerBound(), .000000001d);
      assertEquals("The upper range is", 11, range.getUpperBound(), .000000001d);
    }

    @Test(expected=IllegalArgumentException.class)
    public void scale_negativeFactor(){
      Range range1 = new Range(-10,10);
      Range range = Range.scale(range1,-1);
    }

    //Author: Jonathan
    //================================================================== Range ===============================================================
    @Test 
    public void Range_valid(){
      Range range = new Range(-10,10);
      assertEquals("The lower range is", -10, range.getLowerBound(), .000000001d);
      assertEquals("The upper range is", 10, range.getUpperBound(), .000000001d);
    }

    @Test(expected=IllegalArgumentException.class)
    public void Range_invalid(){
      Range range = new Range(10,-10);
    }
    
    //Author: Jonathan
    //================================================================== hashCode ===============================================================
    @Test
    public void hashCode_valid(){
      Range range = new Range(-10,10);
      int result = range.hashCode();
      assertEquals("The hashcode is", 7.077888E7, result, .000000001d);
    }
    
    @Test
    public void hashCode_NaN(){
        Range range = new Range(Double.NaN,Double.NaN);
        int result = range.hashCode();
        assertEquals("The hashcode is", -1.572864E7, result, .000000001d);
      }

  }
