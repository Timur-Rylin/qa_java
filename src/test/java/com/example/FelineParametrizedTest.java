package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import java.util.Arrays;
import java.util.Collection;
import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class FelineParametrizedTest {

    private final int input;
    private final int expected;

    public FelineParametrizedTest(int input, int expected) {
        this.input = input;
        this.expected = expected;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
                {0, 0},
                {1, 1},
                {5, 5},
                {10, 10}
        });
    }

    @Test
    public void testGetKittensWithDifferentCounts() {
        Feline feline = new Feline();
        assertEquals(expected, feline.getKittens(input));
    }
}