package com.kodilla.stream;

import com.kodilla.stream.beautifier.PoemBeautifier;

public class StreamMain {

    public static void main(String[] args) {
        PoemBeautifier poemBeautifier = new PoemBeautifier();
        String textToBeautify = "Zwykły tekst";

        System.out.println("1: "+poemBeautifier.beautify("Czy upiększacz działa?", n -> ">>> " + n + " <<<"));
        System.out.println("2: "+poemBeautifier.beautify(textToBeautify, n -> n.replaceAll("Zwykły", "Niezwykły")));
        System.out.println("3: "+poemBeautifier.beautify("tylko duże litery", n -> n.toUpperCase()));
        System.out.println("4: "+poemBeautifier.beautify(textToBeautify, n -> n.substring(8)));
        System.out.println("5: "+poemBeautifier.beautify(textToBeautify, n -> n.substring(0, 7)));

        //wynik ostatniego printa u mnie jest taki: "zwyk�y tekst", zamiast "ł" wyświetla "�"
        System.out.println("6: "+poemBeautifier.beautify(textToBeautify, n -> n.toLowerCase()));
    }
}