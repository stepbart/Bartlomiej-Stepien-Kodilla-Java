package com.kodilla.patterns.singleton;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

public class LoggerTestSuite {

    private static Logger logger;
    private static String localDateTime;

    @BeforeAll
    public static void initializingLogger(){
        logger = Logger.INSTANCE;
        localDateTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm"));
        logger.log("1. FIRST LOG ADDED - "+localDateTime);
    }

    @Test
    void test(){
        //Given

        //When & Then
        Assertions.assertEquals("1. FIRST LOG ADDED - "+localDateTime,logger.getLastLog());
    }
}
