package com.kodilla.patterns2.decorator.pizza;

import java.math.BigDecimal;

public class BasicPizzaOrder implements PizzaOrder{
    @Override
    public BigDecimal getPrice() {
        return new BigDecimal(5.00);
    }

    @Override
    public String getDescription() {
        return "Pizza";
    }
}
