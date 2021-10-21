package com.kodilla.sudoku;

import java.util.*;
import java.util.stream.Collectors;

import static com.kodilla.sudoku.Constants.EMPTY;
import static com.kodilla.sudoku.SudokuBoard.*;

public class GameService {

    public static boolean solvingSudoku(SudokuRow sudokuRow){
        boolean isGameOn = false;
        while (!isGameOn){
            updatePossibleNumberInRow(sudokuRow);
            isGameOn=isRowSolved(sudokuRow);
        }
        return isGameOn;
    }

    public static boolean solvingSudoku(SudokuBoard sudokuBoard){
        boolean isGameOn = false;
        while (!isGameOn){
            for (SudokuRow sudokuRow : sudokuBoard.getRowList()){
                isGameOn=updatePossibleNumberInRow(sudokuRow);
            }
            for (SudokuRow sudokuRow : sudokuBoard.getColumnList()){
                isGameOn=updatePossibleNumberInRow(sudokuRow);
            }
            for (SudokuRow sudokuRow : sudokuBoard.getSectionList()){
                isGameOn=updatePossibleNumberInRow(sudokuRow);
            }
        }
        return isGameOn;
    }


    public static boolean isRowSolved(SudokuRow sudokuRow){
        boolean isSolved = false;
        Set<Integer> tempSet = new HashSet<>();
        for (SudokuElement sudokuElement : sudokuRow.getElementList()){
            tempSet.add(sudokuElement.getValue());
        }
        if (!tempSet.contains(EMPTY)){
            isSolved = true;
        }
        return isSolved;
    }

    public static void deleteUsedValueFromAPossibleNumbersInRow(int value, SudokuRow sudokuRow){
        for (SudokuElement sudokuElement : sudokuRow.getElementList()){
            sudokuElement.removeFromPossibleNumbers(value);
        }
    }

    public static boolean updatePossibleNumberInRow(SudokuRow sudokuRow){
        boolean stateChange = false;

        List<Integer> temporaryNumbers = new ArrayList<>();
        for (SudokuElement el : sudokuRow.getElementList()){
            if (el.getValue()!=EMPTY){
                temporaryNumbers.add(el.getValue());
            }
        }


        if (temporaryNumbers.size()==8){
            for (SudokuElement el : sudokuRow.getElementList()){
                if (el.getValue()==EMPTY){
                    el.setValue(findMissingNumber(temporaryNumbers));
                }
            }
        }

        if (temporaryNumbers.size()>0){
            for (SudokuElement el : sudokuRow.getElementList()){
                if (el.getValue()==EMPTY){
                    for (int i : temporaryNumbers){
                        stateChange = true;
                        el.getPossibleNumbers().remove(i);
                    }
                }
            }
        }

        stateChange = checkSimpleFieldState(sudokuRow);
        return stateChange;
    }

    public static boolean checkSimpleFieldState(SudokuRow sudokuRow){
        boolean stateChange = false;
        List<Integer> tempValues = new ArrayList<>();
        Set<Integer> tempPossibleNumbers = new HashSet<>();
        List<Integer> temporarySetAsList = new ArrayList<>();


        for (int i = 0 ; i<9 ; i++){
                tempValues.clear();
                tempPossibleNumbers.clear();
                temporarySetAsList.clear();


            if (sudokuRow.getElementList().get(i).getValue()==EMPTY){
                //robi listę wpisanych wartości w pozostałych polach
                for (SudokuElement sudokuElement : sudokuRow.getElementList()){
                    if (sudokuElement.getValue()!=EMPTY){
                        tempValues.add(sudokuElement.getValue());
                    }
                }

                //robi listę wszystkich możliwych wyników z tablic pustych pól
                for (SudokuElement sudokuElement : sudokuRow.getElementList()){
                    if (sudokuElement.getValue()==EMPTY){
                        tempPossibleNumbers.addAll(sudokuElement.getPossibleNumbers());
                    }
                }
                //usuwa z listy możliwych liczb liczby dla aktualnego pola w iteracji (i)
                tempPossibleNumbers.removeAll(sudokuRow.getElementList().get(i).getPossibleNumbers());

                //przeszktałca set w listę dla łatwiejszych obliczeń
                temporarySetAsList = tempPossibleNumbers.stream().collect(Collectors.toList());

                //sprawdza czy spośród możliwości dla pustego pola są jakieś, których nie można wpisać nigdzie indziej
                if (!isValueUsed(sudokuRow.getElementList().get(i).getPossibleNumbers(),temporarySetAsList) &&
                    !isValueUsed(sudokuRow.getElementList().get(i).getPossibleNumbers(),tempValues)){
                    stateChange = true;


                    sudokuRow.getElementList().get(i).setValue(getOnlyOnePossibleNumberFromValuesList(sudokuRow.getElementList().get(i).getPossibleNumbers(),temporarySetAsList));
                    deleteUsedValueFromAPossibleNumbersInRow(getOnlyOnePossibleNumberFromValuesList(sudokuRow.getElementList().get(i).getPossibleNumbers(),temporarySetAsList),sudokuRow);
                }

                if (findMistake(sudokuRow.getElementList().get(i),tempValues)){
                    //WYLAPUJE BLAD
                }


            }
        }
        return stateChange;
    }

    public static void boardStateCheck(SudokuBoard sudokuBoard){

    }

    public static boolean findMistake(SudokuElement sudokuElement, List<Integer> integerList){
        boolean isMistake = false;
        int tempNumber = EMPTY;
        if (sudokuElement.getPossibleNumbers().size()==1){
            for (int i : sudokuElement.getPossibleNumbers()){
                tempNumber = i;
            }
            if (integerList.contains(tempNumber)){
                isMistake = true;
            }
        }
        return isMistake;
    }

    public static boolean isValueUsed(Set<Integer> possibleValues, List<Integer> values){
        boolean check = true;
        List<Integer> tempList = new ArrayList<>();
        for (int possible : possibleValues){
            if (!values.contains(possible)){
                tempList.add(possible);
            }
        }
        if (tempList.size()>0){
            check = false;
        }
        return check;
    }

    public static int getOnlyOnePossibleNumberFromValuesList(Set<Integer> possibleValues, List<Integer> values){
        int value = EMPTY;
        List<Integer> tempList = new ArrayList<>();
        for (int possible : possibleValues){
            if (!values.contains(possible)){
                tempList.add(possible);
            }
        }
            if (tempList.size()==1){
                value = tempList.get(0);
            }
        return value;
    }

    public static int possibleValue(Set<Integer> possibleValues, List<Integer> values){
        int x = EMPTY;
        for (int possible : possibleValues){
            if (!values.contains(possible)){
                x = possible;
            }
        }
        return x;
    }



    public static List<Integer> fullList() {
        List<Integer> list = new ArrayList<>();
        Integer[] otherList = new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
        list.addAll(Arrays.asList(otherList));
        return list;
    }

    public static int findMissingNumber(List<Integer> numbers){
        List<Integer> tempList = fullList();
        tempList.removeAll(numbers);
        return tempList.get(0);
    }

    public static boolean isSolved(SudokuBoard sudokuBoard){
        boolean isSolved = true;
        for (SudokuRow sudokuRow : sudokuBoard.getRowList()){
            for (SudokuElement sudokuElement : sudokuRow.getElementList()){
                if (sudokuElement.getValue() == EMPTY){
                    isSolved = false;
                }
            }
        }
        return isSolved;
    }

    public static List<SudokuElement> sortedEmptyElementsOfBoard(SudokuBoard sudokuBoard){
        List<SudokuElement> tempList = new ArrayList<>();
        List<SudokuElement> sortedList = new ArrayList<>();

        for (SudokuRow sudokuRow : sudokuBoard.getRowList()){
            for (SudokuElement sudokuElement : sudokuRow.getElementList()){
                if (sudokuElement.getValue()==EMPTY){
                    tempList.add(sudokuElement);
                }
            }
        }

        for (int i = 0 ; i<10 ; i++){
            for (SudokuElement sudokuElement : tempList){
                if (sudokuElement.getPossibleNumbers().size()==i){
                    sortedList.add(sudokuElement);
                }
            }
        }
        return sortedList;
    }



    public static List<SudokuElement> cutRowsToSections(int number, SudokuRow sudokuRow){
        List<SudokuElement> sudokuElements = new ArrayList<>();
        switch (number)
        {
            case 0 :
                sudokuElements.add(sudokuRow.getElementList().get(0));
                sudokuElements.add(sudokuRow.getElementList().get(1));
                sudokuElements.add(sudokuRow.getElementList().get(2));
                break;
            case 1 :
                sudokuElements.add(sudokuRow.getElementList().get(3));
                sudokuElements.add(sudokuRow.getElementList().get(4));
                sudokuElements.add(sudokuRow.getElementList().get(5));
                break;
            case 2 :
                sudokuElements.add(sudokuRow.getElementList().get(6));
                sudokuElements.add(sudokuRow.getElementList().get(7));
                sudokuElements.add(sudokuRow.getElementList().get(8));
                break;
        }
        return sudokuElements;
    }
}
