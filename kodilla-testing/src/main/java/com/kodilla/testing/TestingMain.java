package com.kodilla.testing;

import com.kodilla.testing.calculator.Calculator;

public class TestingMain {
    public static void main(String[] args) {
        System.out.println("Moduł 6. Wprowadzenie to testowania oprogramowania");

        Calculator calcTest = new Calculator();

        //add method test
        if (calcTest.add(11,22)==33) {
            System.out.println("test OK");
        }
        else{
            System.out.println("Error!");
        }

        //substract method test
        if (calcTest.substract(100,99)==1) {
            System.out.println("test OK");
        }
        else{
            System.out.println("Error!");
        }

    }
}