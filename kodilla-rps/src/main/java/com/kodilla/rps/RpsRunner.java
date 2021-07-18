package com.kodilla.rps;

import java.util.Scanner;

public class RpsRunner {

    public static void main(String[] args) throws InterruptedException {
        boolean again = true;

        while (again) {
            boolean gameStillWorks = true;
            RpsPlayer computer = new RpsPlayer("Komputer");
            Scanner scanner1 = new Scanner(System.in);

            System.out.println("Podaj swoje imię: \n");
            String name = scanner1.nextLine();
            System.out.println();
            RpsPlayer player = new RpsPlayer(name);

            System.out.println("Witaj " + player.getName() + "! Podaj liczbę rund: \n");
            int round = scanner1.nextInt();
            System.out.println();

            RpsPlay.printInstructions();

            while (gameStillWorks) {
                while (!RpsPlay.isWinner(player, computer, round)) {
                    Scanner scanner2 = new Scanner(System.in);
                    System.out.println("Wybierz swoją figurę: " + "\n");
                    String playerChoice = scanner2.nextLine();

                    if (playerChoice.equals("x")) {
                        System.out.println("Czy na pewno zakończyć grę? (potwierdź: \"x\")");
                        String playerChoiceConfirm = scanner2.nextLine();
                        if (playerChoiceConfirm.equals("x")) {
                            again = false;
                            scanner1.close();
                            scanner2.close();
                            break;
                        }
                    }

                    if (playerChoice.equals("n")) {
                        System.out.println("Czy na pewno zakończyć aktualną grę? (potwierdź: \"n\")");
                        String playerChoiceConfirm = scanner2.nextLine();
                        if (playerChoiceConfirm.equals("n")) {
                            break;
                        }
                    } else {
                        int number = Integer.parseInt(playerChoice);
                        RpsPlay.nextRound(player, computer, number);
                    }
                }

                if (RpsPlay.isWinner(player, computer, round)) {
                    RpsPlay.whoWhins(player, computer);

                    System.out.println("Jeśli chcesz zakończyć grę - wciśnij \"x\", jeśli zagrać od nowa - wciśnij \"n\"");
                    Scanner scanner3 = new Scanner(System.in);
                    String playerChoice = scanner3.nextLine();

                    if (playerChoice.equals("x")) {
                        System.out.println("Czy na pewno zakończyć grę? (potwierdź: \"x\")");
                        String playerChoiceConfirm = scanner3.nextLine();
                        if (playerChoiceConfirm.equals("x")) {
                            gameStillWorks = false;
                            again = false;
                            scanner1.close();
                            scanner3.close();
                            break;
                        }
                    }

                    if (playerChoice.equals("n")) {
                        System.out.println("Czy na pewno zakończyć aktualną grę? (potwierdź: \"n\")");
                        String playerChoiceConfirm = scanner3.nextLine();
                        if (playerChoiceConfirm.equals("n")) {
                            gameStillWorks = false;
                            break;
                        }
                    }
                }
            }
        }
    }
}
