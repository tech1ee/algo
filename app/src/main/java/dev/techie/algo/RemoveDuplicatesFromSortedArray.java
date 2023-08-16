package dev.techie.algo;

/**
 * LeetCode
 * "Remove Duplicates from Sorted Array"
 * Link: https://leetcode.com/explore/interview/card/top-interview-questions-easy/92/array/727/
 */

public class RemoveDuplicatesFromSortedArray {

    public static int removeDuplicates(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        int uniqueCount = 1; // Initialize with the first element as it's always unique

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1]) {
                nums[uniqueCount] = nums[i];
                uniqueCount++;
            }
        }

        return uniqueCount;
    }
}
