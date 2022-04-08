package dev.techie.algo;

import junit.framework.TestCase;

public class LongestSubstringWithoutRepeatingCharactersTest extends TestCase {

    private LongestSubstringWithoutRepeatingCharacters substringWithoutRepeat =
            new LongestSubstringWithoutRepeatingCharacters();

    public void testLongestSubstringBeforeRepeat() {
        String s = "abcabcbb";
        assertEquals(3, substringWithoutRepeat.lengthOfLongestSubstring(s));
    }

    public void testReturnOneIfAllCharsAreSame() {
        String s = "bbbbb";
        assertEquals(1, substringWithoutRepeat.lengthOfLongestSubstring(s));
    }

    public void testLongestSubstringOverlap() {
        String s = "pwwkew";
        assertEquals(3, substringWithoutRepeat.lengthOfLongestSubstring(s));
    }

    public void testLongestSubstringWithOnlyTwoDifferentChars() {
        String s = "au";
        assertEquals(2, substringWithoutRepeat.lengthOfLongestSubstring(s));
    }
}