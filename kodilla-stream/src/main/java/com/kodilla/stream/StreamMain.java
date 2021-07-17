package com.kodilla.stream;

import com.kodilla.stream.forumuser.Forum;
import com.kodilla.stream.forumuser.ForumUser;

import java.time.LocalDate;
import java.util.Map;
import java.util.stream.Collectors;


public class StreamMain {

    public static void main(String[] args) {

        Forum forum = new Forum();

        Map<Integer, ForumUser> usersMap = forum.getUserList().stream()
                .filter(s -> s.getSex() == 'M')
                .filter(s -> s.getBirthDate().isBefore(LocalDate.of(LocalDate.now().getYear() - 20, LocalDate.now().getMonthValue(), LocalDate.now().getDayOfMonth() + 1)))
                .filter(s -> s.getNumberOfPosts() > 0)
                .collect(Collectors.toMap(ForumUser::getIdentifier, forumUser -> forumUser));

        usersMap.entrySet().stream()
                .forEach(System.out::println);
    }
}