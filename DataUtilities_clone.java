package org.jfree.data;

import static org.junit.Assert.*;

import org.jfree.data.DataUtilities;
import org.jfree.data.Range; 
import org.junit.*;

public class DataUtilities_clone {
	public double source[][];

    @Before
    public void setUp() throws Exception { 
        source = new double[2][2];
        source[0][0] = 1;
        source[0][1] = 2;
        source[1][0] = 3;
        source[1][1] = 4;
    }
    
    @Test
    public void shallowCloneTrue() {
    	assertArrayEquals("Should be equal", source, DataUtilities.clone(source));
    	
    }
    
    @Test
    public void deepCloneFalse() {
    	assertEquals(source, DataUtilities.clone(source));
    }
}
