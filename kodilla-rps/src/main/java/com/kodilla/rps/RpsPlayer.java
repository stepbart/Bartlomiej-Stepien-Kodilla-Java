package com.kodilla.rps;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RpsPlayer {
    private String name;
    private List<RpsPawn> pawns = new ArrayList<>();
    private int roundsWins;

    public void setRoundsWins() {
        this.roundsWins = roundsWins + 1;
    }

    public String getName() {
        return name;
    }

    public int getRoundsWins() {
        return roundsWins;
    }

    public String getLastPawn() {
        return this.pawns.get((pawns.size() - 1)).getName();
    }

    public RpsPlayer(String name) {
        this.name = name;
        this.roundsWins = 0;
    }

    public void nextMove(int number) {
        RpsPawn nextPawn = new RpsPawn();
        nextPawn.setName(number);
        pawns.add(nextPawn);
    }

    public static int rpsComputerMove() {
        return new Random().nextInt(3);
    }
}