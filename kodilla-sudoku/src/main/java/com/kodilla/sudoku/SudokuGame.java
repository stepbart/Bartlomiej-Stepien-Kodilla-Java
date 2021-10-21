package com.kodilla.sudoku;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static com.kodilla.sudoku.GameService.*;
import static com.kodilla.sudoku.SudokuBoard.newBoard;

public class SudokuGame {

    public static void main(String[] args) {

        boolean gameIsOn = false;
        List<SudokuBoard> sudokuBoards = new ArrayList<>();
        SudokuBoard sudokuBoard = newBoard();
        List<Integer> tempList = new ArrayList<>();

        tempList = Arrays.asList(new Integer[]{0,0,0,0,0,0,1,0,7});
        sudokuBoard.getRowList().get(0).setAllValuesForTest(tempList);

        tempList = Arrays.asList(new Integer[]{0,0,0,0,3,0,0,0,0});
        sudokuBoard.getRowList().get(1).setAllValuesForTest(tempList);

        tempList = Arrays.asList(new Integer[]{0,0,0,9,6,2,0,3,5});
        sudokuBoard.getRowList().get(2).setAllValuesForTest(tempList);

        tempList = Arrays.asList(new Integer[]{3,5,1,4,2,9,7,6,8});
        sudokuBoard.getRowList().get(3).setAllValuesForTest(tempList);

        tempList = Arrays.asList(new Integer[]{0,0,6,5,7,0,0,0,0});
        sudokuBoard.getRowList().get(4).setAllValuesForTest(tempList);

        tempList = Arrays.asList(new Integer[]{2,9,7,1,8,0,0,4,3});
        sudokuBoard.getRowList().get(5).setAllValuesForTest(tempList);

        tempList = Arrays.asList(new Integer[]{0,0,0,0,0,0,0,1,0});
        sudokuBoard.getRowList().get(6).setAllValuesForTest(tempList);

        tempList = Arrays.asList(new Integer[]{9,0,4,0,0,0,3,0,6});
        sudokuBoard.getRowList().get(7).setAllValuesForTest(tempList);

        tempList = Arrays.asList(new Integer[]{1,3,0,0,4,0,0,0,0});
        sudokuBoard.getRowList().get(8).setAllValuesForTest(tempList);

        solvingSudoku(sudokuBoard);
        int temp;
        int iter;
        List<SudokuElement> list = sortedEmptyElementsOfBoard(sudokuBoard);
        List<Integer> integerList = new ArrayList<>();
        for (int i = 0 ; i<list.size() ; i++){
            integerList = list.get(i).getPossibleNumbers().stream().collect(Collectors.toList());
        }
        for (int i = 0 ; i<list.size() ; i++){
            temp = list.get(i).getValue();
            for (int n : integerList){
                if (!isSolved(sudokuBoard)){
                    list.get(i).setValue(n);
                    solvingSudoku(sudokuBoard);
                }

                }

            }
        }



    }

