package dev.techie.algo;

public class TypedOutStrings {

    public boolean backspaceCompare(String string1, String string2) {
        return compareStringOptimal(string1, string2);
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

    private boolean compareStringOptimal(String string1, String string2) {
        int p1 = string1.length() - 1;
        int p2 = string2.length() - 1;

        while (p1 >= 0 && p2 >= 0) {
            p1 = nextChar(string1, p1);
            p2 = nextChar(string2, p2);

            if (p1 < 0 && p2 < 0) {
                break;
            } else if (p1 >= 0 && p2 < 0 ||
                    p1 < 0 && p2 >= 0 ||
                    string1.charAt(p1) != string2.charAt(p2)
            ) {
                return false;
            }
            p1--;
            p2--;
        }
        p1 = nextChar(string1, p1);
        p2 = nextChar(string2, p2);

        return p1 == p2;
    }

    private int nextChar(String input, int index) {
        if (index < 0) {
            return -1;
        }
        int hashes = 0;
        while (index >= 0) {
            if (input.charAt(index) == '#') {
                hashes++;
            } else if (hashes > 0) {
                hashes--;
            } else {
                break;
            }
            index--;
        }
        return index;
    }
}
