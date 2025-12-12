package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import java.util.List;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class LionTest {

    @Mock
    Feline felineMock;

    @Test
    public void lionMaleHasMane() throws Exception {
        Lion lion = new Lion(felineMock, "Самец");
        assertTrue(lion.doesHaveMane());
    }

    @Test
    public void lionFemaleHasNoMane() throws Exception {
        Lion lion = new Lion(felineMock, "Самка");
        assertFalse(lion.doesHaveMane());
    }

    @Test(expected = Exception.class)
    public void lionInvalidSexThrowsException() throws Exception {
        new Lion(felineMock, "Неизвестный");
    }

    @Test
    public void getKittensCallsFelineGetKittens() throws Exception {
        when(felineMock.getKittens()).thenReturn(3);
        Lion lion = new Lion(felineMock, "Самец");

        assertEquals(3, lion.getKittens());
        verify(felineMock, times(1)).getKittens();
    }

    @Test
    public void getFoodCallsFelineGetFoodWithPredator() throws Exception {
        List<String> expectedFood = List.of("Мясо");
        when(felineMock.getFood("Хищник")).thenReturn(expectedFood);
        Lion lion = new Lion(felineMock, "Самец");

        List<String> actualFood = lion.getFood();

        assertEquals(expectedFood, actualFood);
        verify(felineMock, times(1)).getFood("Хищник");
    }
}
