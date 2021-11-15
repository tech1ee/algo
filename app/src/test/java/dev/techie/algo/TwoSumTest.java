package dev.techie.algo;

import junit.framework.TestCase;

import java.util.Arrays;

public class TwoSumTest extends TestCase {

    private final TwoSum twoSum = new TwoSum();

    public void testReturnRightIndices() {
        int[] numbers = new int[] {1, 3, 7, 9, 2};
        int target = 11;
        int[] expected = new int[] {3, 4};
        int[] result = twoSum.findTwoSum(numbers, target);
        assertEquals(Arrays.toString(expected), Arrays.toString(result));
    }

    public void testIfThereIsNegativeNumbersReturnNull() {
        int[] result = twoSum.findTwoSum(new int[] {1, 5, -7, 8, -4, 2}, 11);
        assertNull(result);
    }

    public void testIfArrayIsEmptyReturnNull() {
        int[] result = twoSum.findTwoSum(new int[] {}, 11);
        assertNull(result);
    }

    public void testIfNoSolutionReturnNull() {
        int[] result = twoSum.findTwoSum(new int[] {1, 5}, 11);
        assertNull(result);
    }
}