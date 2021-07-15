package com.kodilla.stream.beautifier;

public class PoemBeautifier {

    public String beautify(String textTuBeautify, PoemDecorator poemDecorator){
        String result = poemDecorator.decorate(textTuBeautify);
        return result;
    }
}
