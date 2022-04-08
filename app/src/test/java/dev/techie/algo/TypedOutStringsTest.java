package dev.techie.algo;

import junit.framework.TestCase;

public class TypedOutStringsTest extends TestCase {

    private final TypedOutStrings typedOutStrings = new TypedOutStrings();

    public void testIfAfterHashStringsAreEqual() {
        String string1 = "ab#z";
        String string2 = "az#z";
        assertTrue(typedOutStrings.backspaceCompare(string1, string2));
    }

    public void testIfAfterHashStringsAreNotEqual() {
        String string1 = "abc#d";
        String string2 = "acc#c";
        assertFalse(typedOutStrings.backspaceCompare(string1, string2));
    }

    public void testIfThereTwoHashesDeleteTwoValuesBeforeTheFirstHash() {
        String string1 = "acb##z";
        String string2 = "acz##z";
        assertTrue(typedOutStrings.backspaceCompare(string1, string2));
    }

    public void testIfThereMoreHashesThanValuesRemoveNothing() {
        String string1 = "a###b";
        String string2 = "b";
        assertTrue(typedOutStrings.backspaceCompare(string1, string2));
    }

    public void testIfEmptyStringsAreEqual() {
        String string1 = "x#y#z#";
        String string2 = "b#";
        assertTrue(typedOutStrings.backspaceCompare(string1, string2));
    }

    public void testIfStringsWithDifferentCaseAreNotEqual() {
        String string1 = "Ab#z";
        String string2 = "ab#z";
        assertFalse(typedOutStrings.backspaceCompare(string1, string2));
    }
}