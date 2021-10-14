package com.kodilla.patterns.strategy.social;

import com.kodilla.patterns.strategy.social.publishers.SnapchatPublisher;
import com.kodilla.patterns.strategy.social.publishers.TwitterPublisher;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class UserTestSuite {

    @Test
    void testDefaultSharingStrategies() {
        //Given
        User user1 = new Millenials("Millennial");
        User user2 = new YGeneration("Y Gen");
        User user3 = new ZGeneration("Z Gen");

        //When & Then
        Assertions.assertEquals(user1.getName() + " " + user1.sharePost(), "Millennial shared post on Facebook");
        Assertions.assertEquals(user2.getName() + " " + user2.sharePost(), "Y Gen shared post on Twitter");
        Assertions.assertEquals(user3.getName() + " " + user3.sharePost(), "Z Gen shared post on Snapchat");
    }

    @Test
    void testIndividualSharingStrategy() {
        //Given
        User user1 = new Millenials("Millennial First");
        User user2 = new Millenials("Millennial Second");

        //When
        user1.setSocialPublisher(new TwitterPublisher());
        user2.setSocialPublisher(new SnapchatPublisher());

        //Then
        Assertions.assertEquals(user1.getName() + " " + user1.sharePost(), "Millennial First shared post on Twitter");
        Assertions.assertEquals(user2.getName() + " " + user2.sharePost(), "Millennial Second shared post on Snapchat");
    }
}
