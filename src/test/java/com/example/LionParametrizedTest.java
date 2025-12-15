package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import java.util.Arrays;
import java.util.Collection;
import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class LionParametrizedTest {

    @Mock
    Feline felineMock;

    private final String sex;
    private final boolean expectedHasMane;

    public LionParametrizedTest(String sex, boolean expectedHasMane) {
        this.sex = sex;
        this.expectedHasMane = expectedHasMane;
        MockitoAnnotations.openMocks(this);
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
                {"Самец", true},
                {"Самка", false}
        });
    }

    @Test
    public void testLionConstructorWithValidSex() throws Exception {
        Lion lion = new Lion(felineMock, sex);
        assertEquals(expectedHasMane, lion.doesHaveMane());
    }
}