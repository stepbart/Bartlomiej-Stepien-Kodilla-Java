package com.kodilla.rps;

import java.util.ArrayList;
import java.util.List;

abstract class Player {
    String name;
    List<GamePawn> pawns = new ArrayList<>();
    int roundsWins;

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
}
