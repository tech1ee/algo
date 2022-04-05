package dev.techie.algo;

import junit.framework.TestCase;

public class TrappingRainWaterTest extends TestCase {

    private TrappingRainWater trappingRainWater = new TrappingRainWater();

    public void testTrappingRainWater() {
        int[] input = new int[] {4,2,0,3,2,5};
        assertEquals(9, trappingRainWater.trap(input));
    }
}