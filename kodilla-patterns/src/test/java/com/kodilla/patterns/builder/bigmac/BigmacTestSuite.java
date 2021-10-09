package com.kodilla.patterns.builder.bigmac;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BigmacTestSuite {

    @Test
    void testNewBigMac() {
        //Given
        Bigmac bigmac = new Bigmac.BigmacBuilder()
                .bun("Whole grains with sesame")
                .burgers(2)
                .sauce("standard")
                .ingredient("onion")
                .ingredient("lettuce")
                .ingredient("tomato")
                .ingredient("cucumber")
                .build();

        System.out.println(bigmac);
        //When
        int howManyIngredients = bigmac.getIngredients().size();
        //Then
        assertEquals(4, howManyIngredients);
    }
}
