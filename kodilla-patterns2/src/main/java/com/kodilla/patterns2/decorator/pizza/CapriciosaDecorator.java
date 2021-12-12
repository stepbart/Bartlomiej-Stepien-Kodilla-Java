package com.kodilla.patterns2.decorator.pizza;

import java.math.BigDecimal;

public class CapriciosaDecorator extends AbstractPizzaOrderDecorator{

    public CapriciosaDecorator(PizzaOrder pizzaOrder) {
        super(pizzaOrder);
    }

    @Override
    public BigDecimal getPrice() {
        return super.getPrice().add(new BigDecimal(15));
    }

    @Override
    public String getDescription() {
        return super.getDescription() + ", ingredients: ham, mushrooms, artichokes";
    }
}