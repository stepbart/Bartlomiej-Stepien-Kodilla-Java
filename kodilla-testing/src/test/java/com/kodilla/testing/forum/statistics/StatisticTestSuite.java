package com.kodilla.testing.forum.statistics;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class StatisticTestSuite {

    @Mock
    private Statistics statisticsMock;

    @Test
    void calculateAdvStatisticsIfThereIsNoPosts() {

        //Given
        ForumStatistics forumStatistics = new ForumStatistics();
        int numberOfPosts = 0;

        //When
        when(statisticsMock.postsCount()).thenReturn(numberOfPosts);
        forumStatistics.calculateAdvStatistics(statisticsMock);

        //Then
        Assertions.assertEquals(0, forumStatistics.numberOfPosts);

    }

    @Test
    void calculateAdvStatisticsIfThereIs1000Posts() {

        //Given
        ForumStatistics forumStatistics = new ForumStatistics();
        int numberOfPosts = 1000;

        //When
        when(statisticsMock.postsCount()).thenReturn(numberOfPosts);
        forumStatistics.calculateAdvStatistics(statisticsMock);

        //Then
        Assertions.assertEquals(1000, forumStatistics.numberOfPosts);
    }

    @Test
    void calculateAdvStatisticsIfThereIsNoComments() {

        //Given
        ForumStatistics forumStatistics = new ForumStatistics();
        int numberOfComments = 0;

        //When
        when(statisticsMock.commentsCount()).thenReturn(numberOfComments);
        forumStatistics.calculateAdvStatistics(statisticsMock);

        //Then
        Assertions.assertEquals(0, forumStatistics.numberOfComments);
    }

    @Test
    void calculateAdvStatisticsIfThereIsMorePostsThanComments() {

        //Given
        ForumStatistics forumStatistics = new ForumStatistics();
        int numberOfComments = 2;
        int numberOfPosts = 1;

        //When
        when(statisticsMock.postsCount()).thenReturn(numberOfPosts);
        when(statisticsMock.commentsCount()).thenReturn(numberOfComments);
        forumStatistics.calculateAdvStatistics(statisticsMock);

        //Then
        Assertions.assertFalse(forumStatistics.numberOfPosts > forumStatistics.numberOfComments);
    }

    @Test
    void calculateAdvStatisticsIfThereIsMoreCommentsThanPosts() {

        //Given
        ForumStatistics forumStatistics = new ForumStatistics();
        int numberOfComments = 2;
        int numberOfPosts = 1;

        //When
        when(statisticsMock.postsCount()).thenReturn(numberOfPosts);
        when(statisticsMock.commentsCount()).thenReturn(numberOfComments);
        forumStatistics.calculateAdvStatistics(statisticsMock);

        //Then
        Assertions.assertTrue(forumStatistics.numberOfPosts < forumStatistics.numberOfComments);
    }

    @Test
    void calculateAdvStatisticsIfThereIsNoUsers() {

        //Given
        ForumStatistics forumStatistics = new ForumStatistics();
        List<String> listOfUsers = new ArrayList<>();

        //When
        when(statisticsMock.usersNames()).thenReturn(listOfUsers);
        forumStatistics.calculateAdvStatistics(statisticsMock);

        //Then
        Assertions.assertEquals(0, forumStatistics.numberOfUsers);
    }

    @Test
    void calculateAdvStatisticsIfThereIs100Users() {

        //Given
        ForumStatistics forumStatistics = new ForumStatistics();
        List<String> listOfUsers = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            listOfUsers.add("Nazwa " + i);
        }

        //When
        when(statisticsMock.usersNames()).thenReturn(listOfUsers);
        forumStatistics.calculateAdvStatistics(statisticsMock);

        //Then
        Assertions.assertEquals(100, forumStatistics.numberOfUsers);
    }
}
