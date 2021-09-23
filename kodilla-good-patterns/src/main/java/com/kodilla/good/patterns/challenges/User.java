package com.kodilla.good.patterns.challenges;

import java.util.ArrayList;
import java.util.List;

public class User {
    private String nick;
    private String emailAddress;
    private String phoneNumber;
    private int userID;
    private List<Order> ordersList = new ArrayList<>();

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public List<Order> getOrdersList() {
        return ordersList;
    }

    public User(String nick, int userID) {
        this.nick = nick;
        this.userID = userID;
    }
}
