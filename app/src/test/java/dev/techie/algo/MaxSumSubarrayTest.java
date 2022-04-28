package dev.techie.algo;

import junit.framework.TestCase;

public class MaxSumSubarrayTest extends TestCase {

    public void testMaxSumSubarray() {
        assertEquals(16, MaxSumSubarray.findMaxSumSubarray(new int[] {4,2,1,7,8,1,2,8,1,0}, 3));
    }
}