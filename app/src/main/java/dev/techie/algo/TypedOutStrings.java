package dev.techie.algo;

public class TypedOutStrings {

    public boolean backspaceCompare(String string1, String string2) {
       return backspaceCompareBruteForce(string1, string2);
    }

    private boolean backspaceCompareBruteForce(String string1, String string2) {
        String newString1 = buildString(string1);
        String newString2 = buildString(string2);
        return newString1.equals(newString2);
    }

    private String buildString(String string) {
        StringBuilder stringBuilder = new StringBuilder();

        for (int p = 0; p < string.length(); p++) {
            char c = string.charAt(p);
            if (c != '#') {
                stringBuilder.append(c);
            } else if (stringBuilder.length() > 0) {
                stringBuilder.deleteCharAt(stringBuilder.length() - 1);
            }
        }
        return stringBuilder.toString();
    }
}
