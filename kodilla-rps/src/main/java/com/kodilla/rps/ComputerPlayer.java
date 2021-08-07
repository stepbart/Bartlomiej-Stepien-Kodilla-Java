package com.kodilla.rps;

import java.util.Random;

import static com.kodilla.rps.Constants.COMP_NAME;

public class ComputerPlayer extends Player {

    public ComputerPlayer() {
        this.name = COMP_NAME;
        this.roundsWins = 0;
    }

    public void nextMove() {
        GamePawn nextPawn = new GamePawn();
        nextPawn.setName(new Random().nextInt(3));
        pawns.add(nextPawn);
    }

}
