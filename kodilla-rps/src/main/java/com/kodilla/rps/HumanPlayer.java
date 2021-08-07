package com.kodilla.rps;

public class HumanPlayer extends Player {

    public HumanPlayer(String name) {
        this.name = name;
        this.roundsWins = 0;
    }

    public void nextMove(int number) {
        GamePawn nextPawn = new GamePawn();
        nextPawn.setName(number);
        pawns.add(nextPawn);
    }

}