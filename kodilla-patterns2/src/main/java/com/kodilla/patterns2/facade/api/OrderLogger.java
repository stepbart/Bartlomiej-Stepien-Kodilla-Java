package com.kodilla.patterns2.facade.api;

import com.kodilla.patterns2.aop.calculator.Watcher;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Aspect
@Component
public class OrderLogger {
    private static final Logger LOGGER = LoggerFactory.getLogger(OrderLogger.class);

    @After("execution(* com.kodilla.patterns2.facade.api.OrderFacade.processOrder(..))")
    public void logEvent() {
        LOGGER.info("Złożono zamówienie.");
    }

}
