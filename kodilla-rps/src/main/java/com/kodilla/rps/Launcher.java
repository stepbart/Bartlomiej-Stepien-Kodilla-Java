package com.kodilla.rps;

import java.util.Scanner;

public class Launcher {

    public static void main(String[] args) throws InterruptedException {
        boolean again = true;

        while (again) {
            boolean gameStillWorks = true;
            ComputerPlayer computer = new ComputerPlayer();
            Scanner scan = new Scanner(System.in);

            System.out.println("Podaj swoje imię: \n");
            String name = scan.nextLine();
            System.out.println();
            HumanPlayer player = new HumanPlayer(name);

            System.out.println("Witaj " + player.getName() + "! Podaj liczbę rund: \n");
            int round = scan.nextInt();
            scan.nextLine();
            System.out.println();

            Instructions.printInstructions();

            while (gameStillWorks) {
                while (!GameService.isWinner(player, computer, round)) {
                    System.out.println("Wybierz swoją figurę (Kamień - 1, Papier - 2, Nożyce - 3) : " + "\n");
                    String playerChoice = scan.nextLine();

                    if (playerChoice.equals("x")) {
                        System.out.println("Czy na pewno zakończyć grę? (potwierdź: \"x\")");
                        String playerChoiceConfirm = scan.nextLine();
                        if (playerChoiceConfirm.equals("x")) {
                            again = false;
                            scan.close();
                            break;
                        }
                    }

                    if (playerChoice.equals("n")) {
                        System.out.println("Czy na pewno zakończyć aktualną grę? (potwierdź: \"n\")");
                        String playerChoiceConfirm = scan.nextLine();
                        if (playerChoiceConfirm.equals("n")) {
                            break;
                        }
                    } else {
                        int number = Integer.parseInt(playerChoice);
                        GameService.nextRound(player, computer, number);
                    }
                }

                if (GameService.isWinner(player, computer, round)) {
                    GameService.whoWhins(player, computer);

                    System.out.println("Jeśli chcesz zakończyć grę - wciśnij \"x\", jeśli zagrać od nowa - wciśnij \"n\"");
                    String playerChoice = scan.nextLine();

                    if (playerChoice.equals("x")) {
                        System.out.println("Czy na pewno zakończyć grę? (potwierdź: \"x\")");
                        String playerChoiceConfirm = scan.nextLine();
                        if (playerChoiceConfirm.equals("x")) {
                            gameStillWorks = false;
                            again = false;
                            scan.close();
                            break;
                        }
                    }

                    if (playerChoice.equals("n")) {
                        System.out.println("Czy na pewno zakończyć aktualną grę? (potwierdź: \"n\")");
                        String playerChoiceConfirm = scan.nextLine();
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
