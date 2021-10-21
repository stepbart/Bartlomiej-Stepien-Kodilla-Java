package com.kodilla.sudoku;

import java.util.HashSet;
import java.util.Set;

import static com.kodilla.sudoku.Constants.*;

public class SudokuElement {
    private int value = EMPTY;
    private Set<Integer> possibleNumbers = new HashSet();

    @Override
    public String toString() {
        String presentation = X;
        if (value!=EMPTY){
            presentation = Integer.toString(value);
        }
        return presentation;
    }

    public int getValue() {
        return value;
    }

    public void setPossibleNumbers(Set<Integer> possibleNumbers) {
        this.possibleNumbers = possibleNumbers;
    }

    public void setValue(int value) {
        this.value = value;
        possibleNumbers.remove(value);
    }

    public void removeFromPossibleNumbers(int number){
        this.getPossibleNumbers().remove(number);
    }

    public Set<Integer> getPossibleNumbers() {
        return possibleNumbers;
    }

    public void setOneNewPossibleNumber(int number) {
        possibleNumbers.clear();
        possibleNumbers.add(number);
    }

    public void clearPossibleNUmber(){
        possibleNumbers.clear();
    }

    public void removePossibleNumber(int number){
        possibleNumbers.remove(number);
    }

    public void setPossibleNumbers(int number){
        possibleNumbers.add(number);
    }

    public void addPossibleNumbers(int number) {
        possibleNumbers.add(number);
    }

    public SudokuElement(){
        for (int i = 1 ; i<10 ; i++){
            possibleNumbers.add(i);
        }
    }

    public SudokuElement(int number){
        this.value = number;
    }


}
