package org.jfree.data;

import static org.junit.Assert.*;

import org.jfree.data.DataUtilities;
import org.jfree.data.Range; 
import org.junit.*;

public class DataUtilities_equal {
	public double a[][];
	public double b[][];
	public double c[][];
	public double d[][];
	public double e[][];
	
    @Before
    public void setUp() throws Exception { 
        a = new double[2][2];
        a[0][0] = 1;
        a[0][1] = 2;
        a[1][0] = 3;
        a[1][1] = 4;
        
        b = new double[2][2];
        b[0][0] = 1;
        b[0][1] = 2;
        b[1][0] = 3;
        b[1][1] = 4;
        
        // Same size, different values
        c = new double[2][2];
        c[0][0] = 1;
        c[0][1] = 2;
        c[1][0] = 3;
        c[1][1] = 3;
        
        // Column size bigger, not same values
        d = new double[2][3];
        d[0][0] = 1;
        d[0][1] = 2;
        d[0][2] = 3;
        d[1][0] = 3;
        d[1][1] = 4;
        d[1][2] = 2;
        
        // Row size bigger, not same values
        e = new double[3][2];
        e[0][0] = 1;
        e[0][1] = 2;
        e[1][0] = 3;
        e[1][1] = 3;
        e[2][0] = 2;
        e[2][1] = 2;
    }
    
    @Test
    public void sameArrayValues() {
    	assertTrue("Should be equal", DataUtilities.equal(a, b));
    	
    }
    
    @Test
    public void differentArrayValues() {
    	assertFalse("Should be equal", DataUtilities.equal(a, c));
    	
    }
    
    @Test
    public void firstNullArray() {
    	assertFalse("Should be false", DataUtilities.equal(null, b));
    }
    
    @Test
    public void secondNullArray() {
    	assertFalse("Should be false", DataUtilities.equal(a, null));
    }
    
    @Test
    public void bothNullArray() {
    	assertTrue("Should be false", DataUtilities.equal(null, null));
    }
    
    @Test
    public void differentColumnSizeArrays() {
    	assertFalse("Should be false", DataUtilities.equal(a,d));
    }
    
    @Test
    public void differentRowSizeArrays() {
    	assertFalse("Should be false", DataUtilities.equal(a,e));
    }
    
}