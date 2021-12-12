package com.kodilla.patterns2.decorator.pizza;

import java.math.BigDecimal;

public class SetOfSaucesDecorator extends AbstractPizzaOrderDecorator{

    public SetOfSaucesDecorator(PizzaOrder pizzaOrder) {
        super(pizzaOrder);
    }

    @Override
    public BigDecimal getPrice() {
        return super.getPrice().add(new BigDecimal(10));
    }

    @Override
    public String getDescription() {
        return super.getDescription() + " + set of sauces";
    }
}