package com.kodilla.stream.forumuser;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public final class Forum {
    private final List<ForumUser> usersList = new ArrayList<>();

    public Forum() {
        usersList.add(new ForumUser(1, "tomek80", 'M',
                LocalDate.of(1990, 12, 1), 13));
        usersList.add(new ForumUser(2, "jankomuzykant", 'M',
                LocalDate.of(1993, 4, 11), 0));
        usersList.add(new ForumUser(3, "neo", 'M',
                LocalDate.of(2004, 4, 21), 8));
        usersList.add(new ForumUser(4, "jovita2006", 'F',
                LocalDate.of(2006, 12, 13), 44));
        usersList.add(new ForumUser(5, "anna.jasinska", 'F',
                LocalDate.of(1990, 8, 18), 1));
        usersList.add(new ForumUser(6, "maciek", 'M',
                LocalDate.of(2001, 7, 17), 3));
    }

    public List<ForumUser> getUserList() {
        return new ArrayList<>(usersList);
    }
}
