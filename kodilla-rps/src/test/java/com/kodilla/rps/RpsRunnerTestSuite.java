package com.kodilla.rps;

import static com.kodilla.rps.GameService.isWinner;
import static com.kodilla.rps.GameService.whoWhins;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class RpsRunnerTestSuite {

    @Test
    void testingOfSettingPawnNames(){
        //Given
        HumanPlayer player = new HumanPlayer("playerTest");
        GamePawn pawn1 = new GamePawn();
        GamePawn pawn2 = new GamePawn();
        GamePawn pawn3 = new GamePawn();

        //When
        pawn1.setName(0);
        pawn2.setName(1);
        pawn3.setName(2);

        //Then
        assertEquals("Kamień",pawn1.getName());
        assertEquals("Papier",pawn2.getName());
        assertEquals("Nożyce",pawn3.getName());
    }

    @Test
    void testingOfGettingLastPawnName(){
        //Given
        HumanPlayer player1 = new HumanPlayer("playerTest1");
        HumanPlayer player2 = new HumanPlayer("playerTest2");
        HumanPlayer player3 = new HumanPlayer("playerTest3");

        //When
        player1.nextMove(0);
        player2.nextMove(1);
        player3.nextMove(2);

        //Then
        assertEquals("Kamień",player1.getLastPawn());
        assertEquals("Papier",player2.getLastPawn());
        assertEquals("Nożyce",player3.getLastPawn());
    }

    @Test
    void countinWinningRounds(){
        //Given
        HumanPlayer player1 = new HumanPlayer("playerTest1");
        HumanPlayer player2 = new HumanPlayer("playerTest2");
        HumanPlayer player3 = new HumanPlayer("playerTest3");
        HumanPlayer player4 = new HumanPlayer("playerTest4");

        //When
        player1.setRoundsWins();
        player2.setRoundsWins();
        player2.setRoundsWins();
        player2.setRoundsWins();
        player3.setRoundsWins();
        player3.setRoundsWins();
        player3.setRoundsWins();
        player3.setRoundsWins();
        player3.setRoundsWins();

        //Then
        assertEquals(1, player1.getRoundsWins());
        assertEquals(3, player2.getRoundsWins());
        assertEquals(5, player3.getRoundsWins());
        assertEquals(0, player4.getRoundsWins());
    }

    @Test
    void testIsWinner(){
        //Given
        HumanPlayer player1 = new HumanPlayer("playerTest1");
        HumanPlayer player2 = new HumanPlayer("playerTest2");
        player1.setRoundsWins();
        player2.setRoundsWins();
        player2.setRoundsWins();

        //When
        boolean testValue1 = isWinner(player1,player2,2);
        boolean testValue2 = isWinner(player1,player2,3);
        boolean testValue3 = isWinner(player2,player1,2);

        //Then
        assertTrue(testValue1);
        assertTrue(testValue3);
        assertFalse(testValue2);
    }

    @Test
    void testWhoWhins(){
        //Given
        HumanPlayer player1 = new HumanPlayer("playerTest1");
        player1.setRoundsWins();
        player1.setRoundsWins();
        HumanPlayer player2 = new HumanPlayer("playerTest2");
        player2.setRoundsWins();

        //When
        whoWhins(player1,player2);

        //Then
        assertEquals(player1.getName() + " wygrał grę!", "playerTest1 wygrał grę!");
        assertEquals("2 : 1", player1.getRoundsWins()+" : "+player2.getRoundsWins());
    }

    @Test
    void testShowWhoWinsAndAddPoint(){
        //Given
        HumanPlayer player1 = new HumanPlayer("playerTest1");
        HumanPlayer player2 = new HumanPlayer("playerTest2");

        //When
        GameService.showWhoWinsAndAddPoint(player1);
        GameService.showWhoWinsAndAddPoint(player2);
        GameService.showWhoWinsAndAddPoint(player2);

        //Then
        assertEquals(1, player1.getRoundsWins());
        assertEquals(2, player2.getRoundsWins());
        assertEquals(player2.getName() + " wygrał tę rundę!", "playerTest2 wygrał tę rundę!");

    }
}

