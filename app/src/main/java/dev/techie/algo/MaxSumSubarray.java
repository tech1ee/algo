package dev.techie.algo;

public class MaxSumSubarray {

    /**
     * Find the max sum subarray of a fixed size K
     *
     * Example input:
     * [4,2,1,7,8,1,2,8,1,0]
     */
    public static int findMaxSumSubarray(int[] arr, int k) {
        int maxValue = Integer.MIN_VALUE;
        int currentRunningSum = 0;

        for (int i = 0; i < arr.length; i++) {
            currentRunningSum += arr[i];
            if (i >= k - 1) {
                maxValue = Math.max(maxValue, currentRunningSum);
                currentRunningSum -= arr[i - (k - 1)];
            }
        }

        return maxValue;
    }
}
