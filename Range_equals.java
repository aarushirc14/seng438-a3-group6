package org.jfree.data;

import static org.junit.Assert.*; 
import org.jfree.data.Range; 
import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized.Parameters;
import org.junit.runners.Parameterized;
import java.util.*;

// Author: Luke
// Test cases testing 
// Used parameterized testing in order to reduce redundancy.

@RunWith(Parameterized.class)
public class Range_equals {
    private Range exampleRange;
    public double x1,y1;
    public boolean isTrue;

    public Range_equals(double x1, double y1, boolean expected) {
        this.x1 = x1; 
        this.y1 = y1;
        this.isTrue = expected;
    }

    @Parameters public static Collection<Object[]> parameters() {
        return Arrays.asList(new Object[][] {
            {-1, 1, true}, 
            {-0.5, 0.5, false},
            {0, 1, false}, 
            {-50, 1, false}, 
            {-1, 5, false}, 
            {-1, 0, false}, 
            {50, 100, false}, 
            {-50, -5, false}});
    }

    @Before
    public void setUp() throws Exception { 
        exampleRange = new Range(-1, 1);
    }
    
    @Test
    public void invalidRangePassed() {
    	assertFalse("Ranges should not be equal", exampleRange.equals(new Object()));
    }

    @Test
    public void rangeShouldBeEqual() {
        Assume.assumeTrue(isTrue);
        assertTrue("Ranges should be equal", exampleRange.equals(new Range(x1, y1)));
    }

    @Test
    public void rangeShouldNotBeEqual() {
        Assume.assumeTrue(!isTrue);
        assertFalse("Ranges should not be equal", exampleRange.equals(new Range(x1, y1)));
    }
}
