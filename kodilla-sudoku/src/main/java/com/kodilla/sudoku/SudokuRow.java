package com.kodilla.sudoku;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class SudokuRow {
    private List<SudokuElement> elementList = new ArrayList<>();

    public List<SudokuElement> getElementList() {
        return elementList;
    }

    public void setElementList(SudokuElement... sudokuElement){
        for (int i = 0 ; i<sudokuElement.length ; i++){
            elementList.remove(i);
            elementList.add(i,sudokuElement[i]);
        }
    }

    public void addElementToList(SudokuElement sudokuElement){
        elementList.add(sudokuElement);
    }

    public void clearElements(){
        elementList.clear();
    }

    @Override
    public String toString() {
        String rowView = "|";
        for (int i = 0 ; i<9 ; i++){
            rowView += " "+elementList.get(i)+" ";
            if (i==2 || i==5 || i==8){
                rowView += "|";
            }
        }
        return rowView;
    }

    public SudokuRow(){
        for (int i = 0 ; i<9 ; i++){
            SudokuElement sudokuElement = new SudokuElement();
            elementList.add(sudokuElement);
        }
    }

    public SudokuRow(SudokuElement... sudokuElement){
        for (SudokuElement element : sudokuElement){
            elementList.add(element);
        }
        if (sudokuElement.length!=9){
            int missingElements = 9 - this.elementList.size();
            for (int i = 0 ; i<missingElements ; i++){
                SudokuElement se = new SudokuElement();
                elementList.add(se);
            }
        }

    }

    public static SudokuRow emptyRow(){
        SudokuRow sudokuRow = new SudokuRow();
        sudokuRow.getElementList().clear();
        return sudokuRow;
    }

    public static void addElementsToSection(List<SudokuElement> sudokuElements, SudokuRow sudokuRow){
        sudokuRow.elementList.addAll(sudokuElements);
    }

    public void setAllValuesForTest(List<Integer> numbers){
        for (int i = 0 ; i<9 ; i++){
            if (numbers.get(i)!=0){
                this.elementList.get(i).setValue(numbers.get(i));
            }

        }
    }
}
