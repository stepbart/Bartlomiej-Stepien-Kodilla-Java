package com.kodilla.good.patterns.challenges;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class OrderIDReceiver implements OrderList{
    private List<Integer> ordersList = new ArrayList();

    @Override
    public int getNewOrderID(User user, LocalDate localDate, LocalTime localTime) {
        String newStringID = Integer.toString(user.getUserID())+localDate.toString()+localTime.toString();
            return Integer.parseInt(newStringID);
    }
}
