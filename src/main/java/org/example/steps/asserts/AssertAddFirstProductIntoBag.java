package org.example.steps.asserts;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class AssertAddFirstProductIntoBag {

    public void assertionFirstProductInt(String expectedProductName, String actualProductName) {
        assertTrue(expectedProductName.contains(actualProductName));
    }
}
