package dev.techie.algo;

import android.util.Log;

public class MaxWaterContainer {

    /**
     * Time: O(N^2)
     * Space: O(1)
     */
    public int getMaxWaterContainer(int[] heights) {
        int maxArea = 0;
        for (int p1 = 0; p1 < heights.length; p1++) {
            for (int p2 = p1 + 1; p2 < heights.length; p2++) {
                int height = Math.min(heights[p1], heights[p2]);
                int width = p2 - p1;
                int area = height * width;
                maxArea = Math.max(maxArea, area);
            }
        }
        return maxArea;
    }

    public int getMaxWaterContainerOptimal(int[] heights) {
        int p1 = 0;
        int p2 = heights.length - 1;
        int maxArea = 0;
        while (p1 < p2) {
            int height = Math.min(heights[p1], heights[p2]);
            int width = p2 - p1;
            int area = height * width;
            maxArea = Math.max(maxArea, area);

            if (heights[p1] <= heights[p2]) p1++;
            else p2++;
        }
        return maxArea;
    }
}
