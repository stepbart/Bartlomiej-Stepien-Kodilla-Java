package com.kodilla.sudoku;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;

import static com.kodilla.sudoku.GameService.*;
import static com.kodilla.sudoku.SudokuBoard.deepCopy;
import static com.kodilla.sudoku.SudokuBoard.newBoard;

public class SudokuTestSuite {

    @Test
    void possibleNumbersUpdaterTest() {
        //Given
        SudokuRow sudokuRow = new SudokuRow();
        SudokuElement sudokuElement1 = new SudokuElement();
        SudokuElement sudokuElement2 = new SudokuElement();
        SudokuElement sudokuElement3 = new SudokuElement();
        SudokuElement sudokuElement4 = new SudokuElement();
        SudokuElement sudokuElement5 = new SudokuElement();
        SudokuElement sudokuElement6 = new SudokuElement();
        SudokuElement sudokuElement7 = new SudokuElement();
        SudokuElement sudokuElement8 = new SudokuElement();
        SudokuElement sudokuElement9 = new SudokuElement();
        sudokuElement1.setValue(4);
        sudokuElement2.setValue(5);
        sudokuElement3.setValue(9);
        sudokuElement5.setValue(3);
        sudokuElement6.setValue(6);
        sudokuElement7.setValue(7);
        sudokuElement8.setValue(8);
        sudokuElement9.setValue(1);
        sudokuRow.setElementList(sudokuElement1, sudokuElement2,
                sudokuElement3, sudokuElement4, sudokuElement5, sudokuElement6, sudokuElement7, sudokuElement8, sudokuElement9);

        //when
        updatePossibleNumberInRow(sudokuRow);

        //Then
        Assertions.assertEquals(2, sudokuElement4.getValue());
    }

    @Test
    void checkSimpleFieldStateTest() {
        //Given
        SudokuRow sudokuRow = new SudokuRow();
        SudokuElement sudokuElement1 = new SudokuElement();
        SudokuElement sudokuElement2 = new SudokuElement();
        SudokuElement sudokuElement3 = new SudokuElement();
        SudokuElement sudokuElement4 = new SudokuElement();
        SudokuElement sudokuElement5 = new SudokuElement();
        SudokuElement sudokuElement6 = new SudokuElement();
        SudokuElement sudokuElement7 = new SudokuElement();
        SudokuElement sudokuElement8 = new SudokuElement();
        SudokuElement sudokuElement9 = new SudokuElement();
        sudokuElement1.setValue(1);
        sudokuElement2.setValue(2);
        sudokuElement3.setValue(3);
        sudokuElement4.setValue(4);
        sudokuElement5.setValue(5);
        sudokuElement6.setValue(6);
        sudokuElement7.setValue(7);
        sudokuElement8.setOneNewPossibleNumber(8);
        sudokuElement8.setOneNewPossibleNumber(9);
        sudokuElement9.setOneNewPossibleNumber(9);
        sudokuRow.setElementList(sudokuElement1, sudokuElement2,
                sudokuElement3, sudokuElement4, sudokuElement5, sudokuElement6, sudokuElement7, sudokuElement8, sudokuElement9);

        //when
        updatePossibleNumberInRow(sudokuRow);

        //Then
        Assertions.assertEquals(9, sudokuElement8.getValue());
    }

    @Test
    public void isValueUsedTest() {
        //Given
        Set<Integer> newSet = new HashSet<>();
        List<Integer> newList = new ArrayList<>();
        newSet.add(1);
        newSet.add(2);
        newSet.add(3);
        newSet.add(4);
        newList.add(1);
        newList.add(2);
        newList.add(3);
        newList.add(5);

        //When
        possibleValue(newSet, newList);

        //Then
        Assertions.assertEquals(4, possibleValue(newSet, newList));

    }

    @Test
    void solvingSudokuTest() {
        //Given
        SudokuRow sudokuRow = new SudokuRow();
        SudokuElement sudokuElement1 = new SudokuElement();
        SudokuElement sudokuElement2 = new SudokuElement();
        SudokuElement sudokuElement3 = new SudokuElement();
        SudokuElement sudokuElement4 = new SudokuElement();
        SudokuElement sudokuElement5 = new SudokuElement();
        SudokuElement sudokuElement6 = new SudokuElement();
        SudokuElement sudokuElement7 = new SudokuElement();
        SudokuElement sudokuElement8 = new SudokuElement();
        SudokuElement sudokuElement9 = new SudokuElement();

        sudokuElement1.setOneNewPossibleNumber(1);
        sudokuElement1.addPossibleNumbers(7);

        sudokuElement2.setValue(2);

        sudokuElement3.setOneNewPossibleNumber(3);
        sudokuElement3.addPossibleNumbers(9);
        sudokuElement3.addPossibleNumbers(8);
        sudokuElement3.addPossibleNumbers(7);

        sudokuElement4.setValue(4);

        sudokuElement5.setValue(5);

        sudokuElement6.setOneNewPossibleNumber(6);
        sudokuElement6.addPossibleNumbers(7);
        sudokuElement6.addPossibleNumbers(8);
        sudokuElement6.addPossibleNumbers(9);

        sudokuElement7.setOneNewPossibleNumber(7);
        sudokuElement7.addPossibleNumbers(8);
        sudokuElement7.addPossibleNumbers(9);

        sudokuElement8.setOneNewPossibleNumber(8);
        sudokuElement8.addPossibleNumbers(9);

        sudokuElement9.setOneNewPossibleNumber(9);

        sudokuRow.setElementList(sudokuElement1, sudokuElement2,
                sudokuElement3, sudokuElement4, sudokuElement5, sudokuElement6, sudokuElement7, sudokuElement8, sudokuElement9);

        //when
        solvingSudoku(sudokuRow);

        //Then
        Assertions.assertEquals(1, sudokuElement1.getValue());
        Assertions.assertEquals(3, sudokuElement3.getValue());
        Assertions.assertEquals(6, sudokuElement6.getValue());
        Assertions.assertEquals(7, sudokuElement7.getValue());
        Assertions.assertEquals(8, sudokuElement8.getValue());
        Assertions.assertEquals(9, sudokuElement9.getValue());
    }

    @Test
    void findMistakeTest(){
        //Given
        SudokuElement sudokuElement1 = new SudokuElement();
        SudokuElement sudokuElement2 = new SudokuElement();
        SudokuElement sudokuElement3 = new SudokuElement();
        SudokuElement sudokuElement4 = new SudokuElement();
        sudokuElement1.setOneNewPossibleNumber(1);
        sudokuElement2.setOneNewPossibleNumber(3);
        sudokuElement3.setOneNewPossibleNumber(5);
        sudokuElement4.setOneNewPossibleNumber(6);
        List<Integer> valuesList = new ArrayList<>();
        valuesList.add(1);
        valuesList.add(2);
        valuesList.add(3);
        valuesList.add(4);
        valuesList.add(5);

        //When & Then

        //Then
        Assertions.assertTrue(findMistake(sudokuElement1,valuesList));
        Assertions.assertTrue(findMistake(sudokuElement2,valuesList));
        Assertions.assertTrue(findMistake(sudokuElement3,valuesList));
        Assertions.assertFalse(findMistake(sudokuElement4,valuesList));
    }

    @Test
    void sudokuElementAndRowConstructorTest(){
        //Given
        SudokuElement se1 = new SudokuElement(1);
        SudokuElement se2 = new SudokuElement(2);
        SudokuElement se3 = new SudokuElement(3);
        SudokuElement se4 = new SudokuElement(4);
        SudokuElement se5 = new SudokuElement(5);
        SudokuElement se6 = new SudokuElement(6);
        SudokuElement se7 = new SudokuElement(7);
        SudokuElement se8 = new SudokuElement(8);
        SudokuElement se9 = new SudokuElement(9);
        SudokuRow sudokuRow1 = new SudokuRow(se1,se2,se3,se4,se5);
        SudokuRow sudokuRow2 = new SudokuRow(se6,se7,se8,se9);
        SudokuRow sudokuRow3 = new SudokuRow(se1,se2,se3,se4,se5,se6,se7,se8,se9);

        //When & Then
        Assertions.assertEquals(4,sudokuRow1.getElementList().get(3).getValue());
        Assertions.assertEquals(9,sudokuRow2.getElementList().get(3).getValue());
        Assertions.assertEquals(9,sudokuRow3.getElementList().get(8).getValue());
        Assertions.assertEquals(Constants.EMPTY,sudokuRow1.getElementList().get(8).getValue());
    }

    @Test
    void newBoardTest(){
        //Given
        SudokuBoard sudokuBoard = newBoard();

        //When
        sudokuBoard.getRowList().get(0).getElementList().get(0).setValue(1);
        sudokuBoard.getRowList().get(0).getElementList().get(1).setValue(2);
        sudokuBoard.getRowList().get(0).getElementList().get(2).setValue(3);
        sudokuBoard.getRowList().get(0).getElementList().get(8).setValue(9);
        sudokuBoard.getRowList().get(7).getElementList().get(4).setValue(8);

        //Then
        Assertions.assertEquals(sudokuBoard.getRowList().get(0).getElementList().get(0),sudokuBoard.getColumnList().get(0).getElementList().get(0));
        Assertions.assertEquals(sudokuBoard.getRowList().get(0).getElementList().get(1),sudokuBoard.getColumnList().get(1).getElementList().get(0));
        Assertions.assertEquals(sudokuBoard.getRowList().get(0).getElementList().get(2),sudokuBoard.getColumnList().get(2).getElementList().get(0));
        Assertions.assertEquals(sudokuBoard.getRowList().get(0).getElementList().get(2),sudokuBoard.getSectionList().get(0).getElementList().get(2));
        Assertions.assertEquals(sudokuBoard.getRowList().get(0).getElementList().get(8),sudokuBoard.getSectionList().get(2).getElementList().get(2));
        Assertions.assertEquals(sudokuBoard.getRowList().get(7).getElementList().get(4),sudokuBoard.getSectionList().get(7).getElementList().get(4));
    }

//    @Test
//    void solvingEasySudoku(){
//        //Given
//        SudokuBoard sudokuBoard = newBoard();
//        List<Integer> tempList = new ArrayList<>();
//
//        tempList = Arrays.asList(new Integer[]{0,2,0,0,0,4,1,0,7});
//        sudokuBoard.getRowList().get(0).setAllValuesForTest(tempList);
//
//        tempList = Arrays.asList(new Integer[]{0,0,9,0,3,0,0,0,0});
//        sudokuBoard.getRowList().get(1).setAllValuesForTest(tempList);
//
//        tempList = Arrays.asList(new Integer[]{0,0,0,9,6,2,0,3,5});
//        sudokuBoard.getRowList().get(2).setAllValuesForTest(tempList);
//
//        tempList = Arrays.asList(new Integer[]{3,5,1,4,2,9,7,6,8});
//        sudokuBoard.getRowList().get(3).setAllValuesForTest(tempList);
//
//        tempList = Arrays.asList(new Integer[]{0,0,6,5,7,0,0,0,0});
//        sudokuBoard.getRowList().get(4).setAllValuesForTest(tempList);
//
//        tempList = Arrays.asList(new Integer[]{2,9,7,1,8,0,0,4,3});
//        sudokuBoard.getRowList().get(5).setAllValuesForTest(tempList);
//
//        tempList = Arrays.asList(new Integer[]{0,0,0,0,0,0,0,1,0});
//        sudokuBoard.getRowList().get(6).setAllValuesForTest(tempList);
//
//        tempList = Arrays.asList(new Integer[]{9,0,4,0,0,0,3,0,6});
//        sudokuBoard.getRowList().get(7).setAllValuesForTest(tempList);
//
//        tempList = Arrays.asList(new Integer[]{1,3,0,0,4,0,0,0,0});
//        sudokuBoard.getRowList().get(8).setAllValuesForTest(tempList);
//
//        System.out.println(sudokuBoard);
//        //When
//        solvingSudoku(sudokuBoard);
//
//        //Then
//        Assertions.assertEquals(3,sudokuBoard.getSectionList().get(7).getElementList().get(0).getValue());
//        Assertions.assertEquals(9,sudokuBoard.getSectionList().get(7).getElementList().get(1).getValue());
//        Assertions.assertEquals(7,sudokuBoard.getSectionList().get(7).getElementList().get(2).getValue());
//        Assertions.assertEquals(2,sudokuBoard.getSectionList().get(7).getElementList().get(3).getValue());
//        Assertions.assertEquals(1,sudokuBoard.getSectionList().get(7).getElementList().get(4).getValue());
//        Assertions.assertEquals(8,sudokuBoard.getSectionList().get(7).getElementList().get(5).getValue());
//        Assertions.assertEquals(6,sudokuBoard.getSectionList().get(7).getElementList().get(6).getValue());
//        Assertions.assertEquals(5,sudokuBoard.getSectionList().get(7).getElementList().get(8).getValue());
//        System.out.println(sudokuBoard);
//    }

    @Test
    void deepCloneTest() throws CloneNotSupportedException {
        //Given
        SudokuBoard sudokuBoard = newBoard();
        List<Integer> tempList = new ArrayList<>();

        tempList = Arrays.asList(new Integer[]{0,2,0,0,0,4,1,0,7});
        sudokuBoard.getRowList().get(0).setAllValuesForTest(tempList);

        tempList = Arrays.asList(new Integer[]{0,0,9,0,3,0,0,0,0});
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

        SudokuBoard clone = deepCopy(sudokuBoard);
//        System.out.println(sudokuBoard.equals(clone));

        tempList = Arrays.asList(new Integer[]{0,9,0,0,0,9,9,0,9});
        sudokuBoard.getRowList().get(0).setAllValuesForTest(tempList);
//        System.out.println(sudokuBoard.equals(clone));

        tempList = Arrays.asList(new Integer[]{0,2,0,0,0,4,1,0,7});
        sudokuBoard.getRowList().get(0).setAllValuesForTest(tempList);

        SudokuBoard clone2 = deepCopy(sudokuBoard);
        sudokuBoard.getRowList().get(0).getElementList().get(0).clearPossibleNUmber();
        clone2.getRowList().get(0).getElementList().get(0).clearPossibleNUmber();
        sudokuBoard.getRowList().get(0).getElementList().get(0).setPossibleNumbers(1);
        clone2.getRowList().get(0).getElementList().get(0).setPossibleNumbers(1);

        System.out.println(sudokuBoard.equals(clone2));
    }

    @Test
    void solveWithGuessingNumbersTest(){
        //Given
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

        System.out.println(sudokuBoard);
        solvingSudoku(sudokuBoard);

    }
}
