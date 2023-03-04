
package org.jfree.data.test;

import static org.junit.Assert.*; 

import org.jfree.data.Range; 

import org.junit.*;

public class ShiftTest {
	private Range zero;
	private Range negative;
	private Range positive;
	private Range both;
	private Range exampleRange;
	
	    @BeforeClass public static void setUpBeforeClass() throws Exception {
	    }


    @Before
    public void setUp() throws Exception { 
    	exampleRange = new Range(-1,1);
    	zero = new Range(0,0);
    	positive = new Range (5.0,10.0);
    	negative = new Range (-5.0,-10.0);
    	both = new Range (-5.0,10.0);
 
    }
    /*
 public static Range shift(Range base, double delta, boolean allowZeroCrossing)
Shifts the range by the specified amount.
Parameters:
base - the base range (null not permitted).
delta - the shift amount.
allowZeroCrossing - a flag that determines whether or not the bounds of the range are allowed to cross zero after adjustment.
Returns:
A new range.
   */
    @Test
    public void shiftZeroPositiveTrue() {
    	assertEquals(new Range(0,10), Range.shift(exampleRange, 1, true));
    }
    
    @Test
    public void shiftZeroPositiveFalse() {
    	assertEquals(new Range(0,5), Range.shift(exampleRange, 1, false));
    }
    
    @Test
    public void shiftNegativeZeroFalse() {
    	assertEquals(new Range(-5,0), Range.shift(exampleRange, -1, false));
    }
    
    
    @After
    public void tearDown() throws Exception {
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {
    }
}
