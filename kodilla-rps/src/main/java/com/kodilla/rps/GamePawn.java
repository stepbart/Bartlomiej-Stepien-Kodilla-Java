package com.kodilla.rps;

import static com.kodilla.rps.Constants.*;

public class GamePawn {
    private String name;

    public void setName(int number) {
        if (number == KAMIEN_NUMBER) {
            this.name = KAMIEN;
        }
        if (number == PAPIER_NUMBER) {
            this.name = PAPIER;
        }
        if (number == NOZYCE_NUMBER) {
            this.name = NOZYCE;
        }
    }

    public String getName() {
        return name;
    }
}
