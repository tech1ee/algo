package dev.techie.algo;

import java.util.ArrayDeque;
import java.util.Queue;

public class LongestSubstringWithoutRepeatingCharacters {

    public int lengthOfLongestSubstring(String s) {
        int length = s.length();
        if (length <= 1) return s.length();

        Queue<Character> seen = new ArrayDeque<>();

        int highest = 0;
        int left = 0;
        int right = 0;

        while (left < length && right < length) {
            if (!seen.contains(s.charAt(right))) {
                seen.add(s.charAt(right++));
                highest = Math.max(highest, seen.size());
            } else {
                seen.remove(s.charAt(left++));
            }
        }

        return highest;
    }
}
