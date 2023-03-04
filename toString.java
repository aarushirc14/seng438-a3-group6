package org.jfree.data.test;

import static org.junit.Assert.*; 

import org.jfree.data.Range; 

import org.junit.*;

public class toString {
	    private Range exampleRange;
	    private Range exampleRange2;
	    private Range exampleRange3;
	    private Range exampleRange4;
	    
	    @BeforeClass public static void setUpBeforeClass() throws Exception {
	    }


    @Before
    public void setUp() throws Exception { 
    	exampleRange = new Range(-1.0, 1.0);
    	exampleRange2 = new Range(5.0, 10.0);
    	exampleRange3 = new Range(-10.0, -5.0);
    	exampleRange4 = new Range(-10.0, 10.0);
 
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

    
    
    @After
    public void tearDown() throws Exception {
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {
    }
}
