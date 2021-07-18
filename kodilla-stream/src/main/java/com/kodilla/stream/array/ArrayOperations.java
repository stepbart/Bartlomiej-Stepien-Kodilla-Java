package com.kodilla.stream.array;

import java.text.DecimalFormat;
import java.util.stream.IntStream;

public interface ArrayOperations {

    static double getAverage(int[] numbers) {
        if (numbers.length == 0) {
            System.out.println("Tablica nie zawiera elementów.");
            return 0;
        }
        if (numbers.length == 1) {
            System.out.println("Tablica zawiera jeden element: [" + numbers[0] + "], średnia wynosi: " + numbers[0]);
            return numbers[0];
        }

        System.out.println("Liczby w tablicy:");
        IntStream.range(0, numbers.length)
                .map(n -> numbers[n]).boxed()
                .map(n -> "[" + Integer.toString(n) + "]")
                .forEach(System.out::print);

        double average = IntStream.range(0, numbers.length)
                .map(n -> numbers[n])
                .average().getAsDouble();

        DecimalFormat decimalFormat = new DecimalFormat("#.###");
        String averageEdited = decimalFormat.format(average);
        System.out.println(", średnia wynosi: " + averageEdited);

        return average;
    }
}
