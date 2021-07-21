package com.kodilla.exception.test;

import com.kodilla.exception.io.FileReaderException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SecondChallengeTestSuite {

    @Test
    void testProbablyIWillThrowException(){
        //Given
        SecondChallenge testSecondChallenge = new SecondChallenge();

       //When & Then
        assertAll(
                () -> assertThrows(Exception.class, () -> testSecondChallenge.probablyIWillThrowException(0,1)),
                () -> assertThrows(Exception.class, () -> testSecondChallenge.probablyIWillThrowException(2,1)),
                () -> assertThrows(Exception.class, () -> testSecondChallenge.probablyIWillThrowException(3,1)),
                () -> assertThrows(Exception.class, () -> testSecondChallenge.probablyIWillThrowException(1.5,1.5)),
                () -> assertDoesNotThrow(() -> testSecondChallenge.probablyIWillThrowException(1, 1)),
                () -> assertDoesNotThrow(() -> testSecondChallenge.probablyIWillThrowException(1.5, 100))
        );

    }
}
