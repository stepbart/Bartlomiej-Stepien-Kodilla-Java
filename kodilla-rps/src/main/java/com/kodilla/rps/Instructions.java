package com.kodilla.rps;

public interface Instructions {

    static void printInstructions() {
        System.out.println("Aby rozegrać rundę w grze Kamień-Papier-Nożyce, należy wybrać jedną z figur:");
        System.out.println("Kamień (wybór klawiszem \"1\")");
        System.out.println("Papier (wybór klawiszem \"2\")");
        System.out.println("Nożyce (wybór klawiszem \"3\")");
        System.out.println("Aby zakończyć grę, wciśnij: \"x\".");
        System.out.println("Aby zacząć od początku, wciśnij: \"n\".");
    }
}
