package org.jfree.data.test;

import static org.junit.Assert.*;

import java.lang.IllegalArgumentException;

import org.jfree.data.DataUtilities;


import org.junit.*;

public class DataUtilities_createNumberArray{
	
	@BeforeClass public static void setUpBeforeClass() throws Exception {
    }


    @Before
    public void setUp() throws Exception { 
    	
    }

    // For testing 1D Array
Number[] Expectedarray = {1.0,2.0,3.0};

double[] ParameterArray = {1.0,2.0,3.0};
double[] ExceptionParameterArray = null;
	// For testing 2D Array
Number [][] Expectedarray2D = {{1.0,2.0,3.0},{4.0,5.0,6.0}};
double [][] ParameterArray2D = {{1.0,2.0,3.0},{4.0,5.0,6.0}};
double [][] ExceptionParameterArray2D = null;

    // Test for 1D Array
    @Test
    public void testcreateNumberArray() {
    	assertArrayEquals("An array of Number objects.",
        Expectedarray, DataUtilities.createNumberArray(ParameterArray));
    }
   // Test for 2D Array
    @Test
    public void testcreateNumberArray2D() {
    	assertArrayEquals("An array of Number objects.",
    	Expectedarray2D, DataUtilities.createNumberArray2D(ParameterArray2D));
    }
    @Test
    public void testcreateNumberArrayOne() {
    	Number[] Expectedarray = {1.0};
    	double[] ParameterArray = {2.0};

    	assertArrayEquals("An array of Number objects.",
        Expectedarray, DataUtilities.createNumberArray(ParameterArray));
    }
    
    @Test(expected = IllegalArgumentException.class)
    
    public void createNumberArrayException() {
    	DataUtilities.createNumberArray(ExceptionParameterArray); 
    }
    
    @Test(expected = IllegalArgumentException.class)
        
    public void createNumberArrayException2D() {
        DataUtilities.createNumberArray2D(ExceptionParameterArray2D);
    }

  
    @After
    public void tearDown() throws Exception {
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {
    }


}
