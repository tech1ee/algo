package dev.techie.algo;

import java.util.HashMap;

public class TwoSum {

    /**
     * Time: O(N2)
     * Space: O(1)
     */
    public int[] findTwoSum(int[] numbers, int target) {
        for (int p1 = 0; p1 < numbers.length; p1++) {
            int numberToFind = target - numbers[p1];
            for (int p2 = p1 + 1; p2 < numbers.length; p2++) {
                if (numberToFind == numbers[p2]) return new int[]{p1, p2};
            }
        }
        return null;
    }

    /**
     *
     */
    public int[] findTwoSumOptimal(int[] numbers, int target) {
        HashMap<Integer, Integer> numbersMap = new HashMap();
        for (int p = 0; p < numbers.length; p++) {
            Integer currentMapVal = numbersMap.get(numbers[p]);
            if (currentMapVal != null && currentMapVal >= 0) return new int[] {currentMapVal, p};
            else {
                int numberToFind = target - numbers[p];
                numbersMap.put(numberToFind, p);
            }
        }
        return null;
    }
}
