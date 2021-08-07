package com.kodilla.rps;

import static com.kodilla.rps.Constants.*;

public class GameService {



    static void nextRound(HumanPlayer player, ComputerPlayer comp, int number) throws InterruptedException {

        player.nextMove(number - 1);
        System.out.println("Wybrałeś: " + player.getLastPawn());
        System.out.println("Teraz ruch komputera.");
        Thread.sleep(1000);
        comp.nextMove();
        System.out.println("Komputer wybrał: " + comp.getLastPawn());
        whoIsWinnerofTheRound(player, comp);
    }

    static void whoIsWinnerofTheRound(Player player, Player comp) {
        String playerPawn = player.getLastPawn();
        String compPawn = comp.getLastPawn();

        if (playerPawn.equals(compPawn)) {
            System.out.println("Jest remis!");
        }

        if (playerPawn.equals(KAMIEN)) {
            if (compPawn.equals(PAPIER)) {
                showWhoWinsAndAddPoint(comp);
            }
            if (compPawn.equals(NOZYCE)) {
                showWhoWinsAndAddPoint(player);
            }
        }

        if (playerPawn.equals(PAPIER)) {
            if (compPawn.equals(KAMIEN)) {
                showWhoWinsAndAddPoint(player);
            }
            if (compPawn.equals(NOZYCE)) {
                showWhoWinsAndAddPoint(comp);
            }
        }

        if (playerPawn.equals(NOZYCE)) {
            if (compPawn.equals(PAPIER)) {
                showWhoWinsAndAddPoint(player);
            }
            if (compPawn.equals(KAMIEN)) {
                showWhoWinsAndAddPoint(comp);
            }
        }
    }

    static void showWhoWinsAndAddPoint(Player player) {
        System.out.println(player.getName() + " wygrał tę rundę!");
        player.setRoundsWins();
    }

    static void whoWhins(Player player, Player comp) {

        System.out.println(player.getName() + " vs " + comp.getName());
        System.out.println(player.getRoundsWins() + " : " + comp.getRoundsWins());

        if (player.getRoundsWins() == comp.getRoundsWins()) {
            System.out.println("Remis!");
        }
        if (player.getRoundsWins() > comp.getRoundsWins()) {
            System.out.println(player.getName() + " wygrał grę!");
        }
        if (player.getRoundsWins() < comp.getRoundsWins()) {
            System.out.println(comp.getName() + " wygrał grę!");
        }
    }

    static boolean isWinner(Player player, Player comp, int numberOfRounds) {
        if (numberOfRounds == player.getRoundsWins() || numberOfRounds == comp.getRoundsWins()) {
            return true;
        } else {
            return false;
        }
    }
}
