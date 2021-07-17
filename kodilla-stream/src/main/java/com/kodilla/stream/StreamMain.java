package com.kodilla.stream;

import com.kodilla.stream.forumuser.Forum;
import com.kodilla.stream.forumuser.ForumUser;


import java.util.Map;
import java.util.stream.Collectors;

import static com.kodilla.stream.forumuser.ForumUser.isOlderThan20;

public class StreamMain {

    public static void main(String[] args) {

        Forum forum = new Forum();

        Map<Integer, ForumUser> usersMap = forum.getUserList().stream()
                .filter(s -> s.getSex() == 'M')
                .filter(s -> isOlderThan20(s.getBirthDate()))
                .filter(s -> s.getNumberOfPosts() > 0)
                .collect(Collectors.toMap(ForumUser::getIdentifier, forumUser -> forumUser));

        usersMap.entrySet().stream()
                .forEach(System.out::println);
    }
}