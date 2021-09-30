package com.kodilla.spring.calculator;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class CalculatorTestSuite {

    @Autowired
    private Calculator calculator;

    @Test
    void testCalculations(){
        //Given
        //When
        calculator.add(1,1);
        calculator.sub(4,1);
        calculator.mul(2,2);
        calculator.div(10,2);
        //Then
    }
}
