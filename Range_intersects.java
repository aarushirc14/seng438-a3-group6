package org.jfree.data.test;

import static org.junit.Assert.*; 
import org.jfree.data.Range; 
import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized.Parameters;
import org.junit.runners.Parameterized;
import java.util.*;

// Author: Luke
// Test cases testing intersects() function in Range class
// Used parameterized testing in order to reduce redundancy.

@RunWith(Parameterized.class)
public class Range_intersects {
    private Range exampleRange;
    public double x1,y1;
    public boolean isTrue;

    public Range_intersects_Tests(double x1, double y1, boolean expected) {
        this.x1 = x1; 
        this.y1 = y1;
        this.isTrue = expected;
    }

    @Parameters public static Collection<Object[]> parameters() {
        return Arrays.asList(new Object[][] {
            // Original:   -1   1
            // Given   :   -1   1
            {-1, 1, true}, 
            // Original:        -1   1
            // Given   :   -5   -1            
            {-5, -1, true},
            // Original:        -1   1
            // Given   :      -2   0
            {-2, 0, true}, 
            // Original:        -1   1
            // Given   :        -1 0
            {-1, 0, true}, 
            // Original:        -1   1
            // Given   :      -2       2
            {-2, 2, true}, 
            // Original: -1   1
            // Given   :      1   2
            {1, 2, true}, 
            // Original: -1   1
            // Given   :    0   2
            {0, 2, true}, 
            // Original: -1   1
            // Given   :    0 1
            {0, 1, true}, 
            // Original: -1          1
            // Given   :   -0.5, 0.5
            {-0.5, 0.5, true},
            // Original: -1      1
            // Given   :           2    3
            {2, 3, false},
            // Original:                -1     1
            // Given   :  -5        -2 
            {-5, -2, false}});
    }

    @Before
    public void setUp() throws Exception { 
        exampleRange = new Range(-1, 1);
    }

    @Test
    public void rangesShouldIntersect() {
        Assume.assumeTrue(isTrue);
        assertTrue("Ranges should intersect", exampleRange.intersects(x1, y1));
    }

    @Test
    public void rangesShouldNotIntersect() {
        Assume.assumeTrue(!isTrue);
        assertFalse("Ranges should not intersect", exampleRange.intersects(x1, y1));
    }

    @Test
    public void rangesIntersectWithObject() {
        Range toCompare = new Range(-1, 1);
        assertTrue("Ranges intersect", exampleRange.intersects(toCompare));
    }
}
