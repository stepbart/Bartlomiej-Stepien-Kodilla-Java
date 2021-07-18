package com.kodilla.rps;

public interface RpsPlay {

    static void printInstructions() {
        System.out.println("Aby rozegrać rundę w grze Kamień-Papier-Nożyce, należy wybrać jedną z figur:");
        System.out.println("Kamień (wybór klawiszem \"1\")");
        System.out.println("Papier (wybór klawiszem \"2\")");
        System.out.println("Nożyce (wybór klawiszem \"3\")");
        System.out.println("Aby zakończyć grę, wciśnij: \"x\".");
        System.out.println("Aby zacząć od początku, wciśnij: \"n\".");
    }

    static void nextRound(RpsPlayer player, RpsPlayer comp, int number) throws InterruptedException {

        player.nextMove(number - 1);
        System.out.println("Wybrałeś: " + player.getLastPawn());
        System.out.println("Teraz ruch komputera.");
        Thread.sleep(1000);
        comp.nextMove(RpsPlayer.rpsComputerMove());
        System.out.println("Komputer wybrał: " + comp.getLastPawn());
        whoIsWinnerofTheRound(player, comp);
        System.out.println("(Kamień - 1, Papier - 2, Nożyce - 3)");
    }

    static void whoIsWinnerofTheRound(RpsPlayer player, RpsPlayer comp) {
        String playerPawn = player.getLastPawn();
        String compPawn = comp.getLastPawn();

        if (playerPawn.equals(compPawn)) {
            System.out.println("Jest remis!");
        }

        if (playerPawn.equals("Kamień")) {
            if (compPawn.equals("Papier")) {
                showWhoWinsAndAddPoint(comp);
            }
            if (compPawn.equals("Nożyce")) {
                showWhoWinsAndAddPoint(player);
            }
        }

        if (playerPawn.equals("Papier")) {
            if (compPawn.equals("Kamień")) {
                showWhoWinsAndAddPoint(player);
            }
            if (compPawn.equals("Nożyce")) {
                showWhoWinsAndAddPoint(comp);
            }
        }

        if (playerPawn.equals("Nożyce")) {
            if (compPawn.equals("Papier")) {
                showWhoWinsAndAddPoint(player);
            }
            if (compPawn.equals("Kamień")) {
                showWhoWinsAndAddPoint(comp);
            }
        }
    }

    static void showWhoWinsAndAddPoint(RpsPlayer player) {
        System.out.println(player.getName() + " wygrał tę rundę!");
        player.setRoundsWins();
    }

    static void whoWhins(RpsPlayer player, RpsPlayer comp) {

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

    static boolean isWinner(RpsPlayer player, RpsPlayer comp, int numberOfRounds) {
        if (numberOfRounds == player.getRoundsWins() || numberOfRounds == comp.getRoundsWins()) {
            return true;
        } else {
            return false;
        }
    }
}
