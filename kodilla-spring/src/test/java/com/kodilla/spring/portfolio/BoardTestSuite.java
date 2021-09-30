package com.kodilla.spring.portfolio;

import com.kodilla.spring.reader.ReaderConfig;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Arrays;

@SpringBootTest
public class BoardTestSuite {

    @Autowired
    Board board;

    @Test
    void testTaskAdd(){
        //Given
        //When
        board.addTaskToDo("TO DO");
        board.addTaskToProgress("IN PROGRESS");
        board.addDoneTask("DONE");
        //Then
        board.showLists();
    }
}
