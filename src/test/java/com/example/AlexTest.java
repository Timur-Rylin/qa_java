package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import java.util.List;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class AlexTest {

    @Mock
    Feline felineMock;

    @Test
    public void alexHasNoKittens() throws Exception {
        Alex alex = new Alex(felineMock);
        assertEquals(0, alex.getKittens());
    }

    @Test
    public void alexHasMane() throws Exception {
        Alex alex = new Alex(felineMock);
        assertTrue(alex.doesHaveMane());
    }

    @Test
    public void getFriendsReturnsCorrectList() throws Exception {
        Alex alex = new Alex(felineMock);
        List<String> expected = List.of("Марти", "Глория", "Мелман");
        assertEquals(expected, alex.getFriends());
    }

    @Test
    public void getPlaceOfLivingReturnsZoo() throws Exception {
        Alex alex = new Alex(felineMock);
        assertEquals("Нью-Йоркский зоопарк", alex.getPlaceOfLiving());
    }

    @Test
    public void alexCanEatFood() throws Exception {
        when(felineMock.getFood("Хищник")).thenReturn(List.of("Мясо"));
        Alex alex = new Alex(felineMock);

        List<String> food = alex.getFood();

        assertNotNull(food);
    }

    @Test
    public void alexGetFoodVerifiesFelineGetFoodCalled() throws Exception {
        when(felineMock.getFood("Хищник")).thenReturn(List.of("Мясо"));
        Alex alex = new Alex(felineMock);

        alex.getFood();

        verify(felineMock, times(1)).getFood("Хищник");
    }
}
