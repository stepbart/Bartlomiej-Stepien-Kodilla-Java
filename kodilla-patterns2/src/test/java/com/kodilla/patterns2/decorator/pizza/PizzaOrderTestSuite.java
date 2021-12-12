package com.kodilla.patterns2.decorator.pizza;

import com.kodilla.patterns2.decorator.taxiportal.BasicTaxiOrder;
import com.kodilla.patterns2.decorator.taxiportal.ChildSeatDecorator;
import com.kodilla.patterns2.decorator.taxiportal.MyTaxiNetworkOrderDecorator;
import com.kodilla.patterns2.decorator.taxiportal.TaxiOrder;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PizzaOrderTestSuite {

    @Test
    public void testPizzaDecorator() {
        //Given
        PizzaOrder pizza = new BasicPizzaOrder();
        pizza = new BiggerSizeDecorator(pizza);
        pizza = new DoubleCheeseDecorator(pizza);
        pizza = new CapriciosaDecorator(pizza);
        pizza = new SetOfSaucesDecorator(pizza);

        //When
        BigDecimal price = new BigDecimal(47);
        String description = pizza.getDescription();

        //Then
        assertEquals(price,pizza.getPrice());
        assertEquals("Pizza XXL with double cheese, ingredients: ham, mushrooms, artichokes + set of sauces", description);
    }
}
