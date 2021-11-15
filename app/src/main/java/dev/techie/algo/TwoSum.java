package dev.techie.algo;

public class TwoSum {

    public int[] findTwoSum(int[] numbers, int target) {
        for (int p1 = 0; p1 < numbers.length; p1++) {
            int numberToFind = target - numbers[p1];
            for (int p2 = p1 + 1; p2 < numbers.length; p2++) {
                if (numberToFind == numbers[p2]) return new int[]{p1, p2};
            }
        }
        return null;
    }
}
