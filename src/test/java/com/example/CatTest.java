package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import java.util.List;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class CatTest {

    @Mock
    Feline felineMock;

    @Test
    public void getSoundReturnsMeow() {
        Cat cat = new Cat(felineMock);
        assertEquals("Мяу", cat.getSound());
    }

    @Test
    public void getFoodCallsEatMeat() throws Exception {
        Cat cat = new Cat(felineMock);
        List<String> expectedFood = List.of("Мясо", "Рыба");
        when(felineMock.eatMeat()).thenReturn(expectedFood);

        List<String> actualFood = cat.getFood();

        assertEquals(expectedFood, actualFood);
    }

    @Test
    public void getFoodVerifiesEatMeatCalled() throws Exception {
        Cat cat = new Cat(felineMock);
        when(felineMock.eatMeat()).thenReturn(List.of("Мясо"));

        cat.getFood();

        verify(felineMock, times(1)).eatMeat();
    }

    @Test(expected = Exception.class)
    public void getFoodPropagatesException() throws Exception {
        Cat cat = new Cat(felineMock);
        when(felineMock.eatMeat()).thenThrow(new Exception("Test exception"));
        cat.getFood();
    }
}