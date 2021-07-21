package com.kodilla.exception.test;

public class FirstChallenge {

    public double divide(double a, double b) throws ArithmeticException {

        try {
            return a/b;
        }
        catch (ArithmeticException arithmeticException){
            throw arithmeticException;
        }
        finally {
            System.out.println("Wynik jest prawidłowy, jeśli nie dzielisz przez zero.");
            if (b==0){
                return 0;
            }
        }
    }

    /**
     * This main can throw an ArithmeticException!!!
     * @param args
     */
    public static void main(String[] args) {
        FirstChallenge firstChallenge = new FirstChallenge();
        double result = firstChallenge.divide(3, 0);

        System.out.println(result);
    }
}