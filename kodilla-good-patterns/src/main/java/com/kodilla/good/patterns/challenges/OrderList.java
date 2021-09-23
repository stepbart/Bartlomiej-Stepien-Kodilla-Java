package com.kodilla.good.patterns.challenges;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public interface OrderList {

    int getNewOrderID(User user, LocalDate localDate, LocalTime localTime);
}
