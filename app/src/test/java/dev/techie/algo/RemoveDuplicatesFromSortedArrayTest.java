package dev.techie.algo;

import junit.framework.TestCase;

public class RemoveDuplicatesFromSortedArrayTest extends TestCase {

    public void testRemoveDuplicates() {
        int[] nums = {1, 1, 2};
        int expected = 2;
        int actual = RemoveDuplicatesFromSortedArray.removeDuplicates(nums);
        assertEquals(expected, actual);
    }

    public void testRemoveDuplicates2() {
        int[] nums = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        int expected = 5;
        int actual = RemoveDuplicatesFromSortedArray.removeDuplicates(nums);
        assertEquals(expected, actual);
    }

    public void testRemoveDuplicates3() {
        int[] nums = {1, 2};
        int expected = 2;
        int actual = RemoveDuplicatesFromSortedArray.removeDuplicates(nums);
        assertEquals(expected, actual);
    }

    public void testRemoveDuplicates4() {
        int[] nums = {1, 1};
        int expected = 1;
        int actual = RemoveDuplicatesFromSortedArray.removeDuplicates(nums);
        assertEquals(expected, actual);
    }

    public void testRemoveDuplicates5() {
        int[] nums = {1};
        int expected = 1;
        int actual = RemoveDuplicatesFromSortedArray.removeDuplicates(nums);
        assertEquals(expected, actual);
    }

    public void testRemoveDuplicates6() {
        int[] nums = {};
        int expected = 0;
        int actual = RemoveDuplicatesFromSortedArray.removeDuplicates(nums);
        assertEquals(expected, actual);
    }

    public void testRemoveDuplicates7() {
        int[] nums = {1, 1, 2, 2, 3, 3, 3, 4, 4, 4};
        int expected = 4;
        int actual = RemoveDuplicatesFromSortedArray.removeDuplicates(nums);
        assertEquals(expected, actual);
    }

    public void testRemoveDuplicates8() {
        int[] nums = {1, 1, 2, 2, 3, 3, 3, 4, 4, 4};
        int expected = 4;
        int actual = RemoveDuplicatesFromSortedArray.removeDuplicates(nums);
        assertEquals(expected, actual);
    }

    public void testRemoveDuplicates9() {
        int[] nums = {1, 1, 2, 2, 3, 3, 3, 4, 4, 4};
        int expected = 4;
        int actual = RemoveDuplicatesFromSortedArray.removeDuplicates(nums);
        assertEquals(expected, actual);
    }
}