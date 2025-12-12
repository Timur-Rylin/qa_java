package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import java.util.Arrays;
import java.util.Collection;
import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

@RunWith(Parameterized.class)
public class LionParametrizedTest {

    @Mock
    Feline felineMock;

    private final String sex;
    private final boolean expectedHasMane;
    private final boolean shouldThrowException;

    public LionParametrizedTest(String sex, boolean expectedHasMane, boolean shouldThrowException) {
        this.sex = sex;
        this.expectedHasMane = expectedHasMane;
        this.shouldThrowException = shouldThrowException;
        MockitoAnnotations.openMocks(this);
    }

    @Parameterized.Parameters(name = "Пол: {0}, ожидается грива: {1}, исключение: {2}")
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
                {"Самец", true, false},
                {"Самка", false, false},
                {"самец", false, true},  // lowercase
                {"самка", false, true},  // lowercase
                {"Male", false, true},   // english
                {"Female", false, true}, // english
                {"", false, true},       // empty
                {null, false, true}      // null
        });
    }

    @Test
    public void testLionConstructorWithDifferentSexValues() throws Exception {

        when(felineMock.getKittens()).thenReturn(1);

        if (shouldThrowException) {
            try {
                new Lion(felineMock, sex);
                fail("Ожидалось исключение для пола: " + sex);
            } catch (Exception e) {
                assertTrue(e.getMessage().contains("Используйте допустимые значения пола"));
            }
        } else {
            Lion lion = new Lion(felineMock, sex);
            assertEquals(expectedHasMane, lion.doesHaveMane());
        }
    }
}
