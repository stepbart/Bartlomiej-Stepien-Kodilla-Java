package com.kodilla.testing;

import com.kodilla.testing.calculator.Calculator;
import com.kodilla.testing.user.SimpleUser;

public class TestingMain {
    public static void main(String[] args) {



        // Testing Calculator class
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