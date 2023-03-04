
package org.jfree.data.test;

import static org.junit.Assert.*; 

import org.jfree.data.Range; 

import org.junit.*;

public class NaNRange {
	private Range zero;
	private Range negative;
	private Range positive;
	private Range both;
	private Range exampleRange;
	    private Range exampleRange2;
	    private Range exampleRange3;
	    private Range exampleRange4;
	    private Range exampleRange5;
	    private Range exampleRange6;
	    private Range exampleRange7;
	    private Range exampleRange8;
	    private Range exampleRange9;
	    private Range exampleRange10;
	    
	    
	    @BeforeClass public static void setUpBeforeClass() throws Exception {
	    }


    @Before
    public void setUp() throws Exception { 
    	exampleRange = new Range(-1,1);
    	zero = new Range(0,0);
    	positive = new Range (5.0,10.0);
    	negative = new Range (-5.0,-10.0);
    	both = new Range (-5.0,10.0);
    	exampleRange = new Range(-1.0, 1.0);
    	exampleRange2 = new Range(5.0, 10.0);
    	exampleRange3 = new Range(-10.0, -5.0);
    	exampleRange4 = new Range(-10.0, 10.0);
    	exampleRange5 = Range.expandToInclude(null, 1.0);
    	exampleRange6 = Range.expandToInclude(null, -1.0);
    	exampleRange7 = Range.expandToInclude(exampleRange, -2.0);
    	exampleRange8 = Range.expandToInclude(exampleRange, 2.0);
    	exampleRange9 = Range.expandToInclude(null, 2.0);
    	exampleRange10 = Range.expandToInclude(exampleRange, 0.5);
    	
    	
    	
 
    }


    @Test
    public void centralValueShouldBeZero() {
        assertEquals("The central value of -1 and 1 should be 0",
        0, exampleRange.getCentralValue(), .000000001d);
    }
    

    @Test
    public void testBaseCase() {
        assertEquals("A String \"Range[lower,upper]\" where lower=lower range and upper=upper range.",
        "Range[-1.0,1.0]", exampleRange.toString());
        System.out.println(exampleRange.toString());
    }
    @Test
    public void edgecasePositivePositive() {
    	assertEquals("A String \"Range[lower,upper]\" where lower=lower range and upper=upper range.",
    	"Range[5.0,10.0]", exampleRange2.toString());
    	System.out.println(exampleRange2.toString());
    }
    @Test
    public void edgecaseNegativeNegative() {
    	assertEquals("A String \"Range[lower,upper]\" where lower=lower range and upper=upper range.",
    	"Range[-10.0, -5.0]", exampleRange3.toString());
    	System.out.println(exampleRange3.toString());
    }
    @Test
    public void edgecaseNegativePositive() {
    	assertEquals("A String \"Range[lower,upper]\" where lower=lower range and upper=upper range.",
    	"Range[-10.0, 10.0]", exampleRange4.toString());
    	System.out.println(exampleRange4.toString());
    }
    
    @Test
    public void expandToIncludeRange5() {
    	assertEquals(1.0, exampleRange5.getLowerBound(), 0.000000001d);
    }
    @Test
    public void expandToIncludeRange6() {
    	assertEquals(-1.0, exampleRange6.getLowerBound(), 0.000000001d);
    }
    @Test
    public void expandToIncludeRange7() {
    	assertEquals(-2.0, exampleRange7.getLowerBound(), 0.000000001d);
    }
    @Test
    public void expandToIncludeRange8() {
    	assertEquals(2.0, exampleRange8.getUpperBound(), 0.000000001d);
    }
    @Test
    public void expandToIncludeRange9() {
    	assertEquals(2.0, exampleRange9.getUpperBound(), 0.000000001d);
    }
    @Test
    public void expandToIncludeRange10() {
    	assertEquals(1.0, exampleRange10.getUpperBound(), 0.000000001d);
    }
    
   
    
    //shift: shifts the range by the specified amount
    /*
    public static Range shift(Range base, double delta)
    Shifts the range by the specified amount.
    Parameters:
    base - the base range (null not permitted).
    delta - the shift amount.
    Returns:
    A new range.
    */
   /*
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
    
*/
    
    @Test
    public void isNaNRange() {
    	exampleRange = new Range(-1, 1);
    	assertFalse(exampleRange.isNaNRange());
    }
    
    @Test
    public void isNaNLow() {
    	exampleRange = new Range(Double.NaN, 1);
    	assertFalse(exampleRange.isNaNRange());
    }
    
    @Test
    public void isNaNHigh() {
    	exampleRange = new Range(-1, Double.NaN);
    	assertFalse(exampleRange.isNaNRange());
    }
    
    @Test
    public void isNaNTrue() {
    	exampleRange = new Range(Double.NaN, Double.NaN);
    	assertTrue(exampleRange.isNaNRange());
    }


    
    @After
    public void tearDown() throws Exception {
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {
    }
}
