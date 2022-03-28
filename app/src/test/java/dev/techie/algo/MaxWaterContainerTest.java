package dev.techie.algo;

import junit.framework.TestCase;

public class MaxWaterContainerTest extends TestCase {

    public void testGetMaxAreaReturnCorrectResult() {
        int[] heights = {7, 1, 2, 3, 9};
        int expected = 28;
        assertEquals(expected, new MaxWaterContainer().getMaxWaterContainerOptimal(heights));
    }
}