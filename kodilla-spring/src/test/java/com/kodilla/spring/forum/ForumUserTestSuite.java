package com.kodilla.spring.forum;

import com.kodilla.spring.forum.ForumUser;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class ForumUserTestSuite {

    @Test
    void testGetUsername() {
        //Given
        ApplicationContext context =
                new AnnotationConfigApplicationContext("com.kodilla.spring");
        ForumUser user = context.getBean(ForumUser.class);

        //When
        String userName = user.getUserName();

        //Then
        assertEquals("John Smith", userName);
    }

}
