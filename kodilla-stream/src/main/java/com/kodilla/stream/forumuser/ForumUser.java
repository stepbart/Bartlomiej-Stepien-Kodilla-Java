package com.kodilla.stream.forumuser;

import java.time.LocalDate;

public final class ForumUser {
    private final int identifier;
    private final String userName;
    private final char sex;
    private final LocalDate birthDate;
    private final int numberOfPosts;

    public ForumUser(int identifier, String userName, char sex, LocalDate birthDate, int numberOfPosts) {
        this.identifier = identifier;
        this.userName = userName;
        this.sex = sex;
        this.birthDate = birthDate;
        this.numberOfPosts = numberOfPosts;
    }

    public int getIdentifier() {
        return identifier;
    }

    public String getUserName() {
        return userName;
    }

    public char getSex() {
        return sex;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public int getNumberOfPosts() {
        return numberOfPosts;
    }

    @Override
    public String toString() {
        String sexToString;
        if (sex == 'M') {
            sexToString = "mężczyzna";
        } else {
            sexToString = "kobieta";
        }
        return "Użytkownik: " + userName +
                " (płeć: " + sexToString +
                ", ur." + birthDate +
                "), liczba postów: " + numberOfPosts;
    }
}
