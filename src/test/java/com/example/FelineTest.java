package com.example;

import org.junit.Test;
import java.util.List;
import static org.junit.Assert.*;

public class FelineTest {

    @Test
    public void eatMeatReturnsPredatorFood() throws Exception {
        Feline feline = new Feline();
        List<String> expected = List.of("Животные", "Птицы", "Рыба");
        assertEquals(expected, feline.eatMeat());
    }

    @Test
    public void getFamilyReturnsFelidae() {
        Feline feline = new Feline();
        assertEquals("Кошачьи", feline.getFamily());
    }

    @Test
    public void getKittensReturnsOne() {
        Feline feline = new Feline();
        assertEquals(1, feline.getKittens());
    }

    @Test
    public void getKittensWithCountThreeReturnsThree() {
        Feline feline = new Feline();
        assertEquals(3, feline.getKittens(3));
    }
}