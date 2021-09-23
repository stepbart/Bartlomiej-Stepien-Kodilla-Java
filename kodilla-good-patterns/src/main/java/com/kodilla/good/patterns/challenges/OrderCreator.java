package com.kodilla.good.patterns.challenges;

import java.util.List;

public interface OrderCreator {

    Order createOrder(User user, List<Product> productList);

}
