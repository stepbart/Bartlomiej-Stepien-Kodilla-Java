package com.kodilla.testing.shape;

import java.util.ArrayList;
import java.util.List;

public class ShapeCollector {

    private List<Shape> figureList = new ArrayList<>();

    public List<Shape> getFigureList() {
        return figureList;
    }

    public void addFigure(Shape shape) {
        figureList.add(shape);
    }

    public void removeFigure(Shape shape) {
        figureList.remove(shape);
    }

    public Shape getFigure(int n) {
        return figureList.get(n);
    }

    public String showFigures() {
        String Figures = "";
        for (int i = 0 ; i<figureList.size() ; i++){
            Figures+=figureList.get(i).getShapeName();
            if (i==figureList.size()-1){}
            else {
                Figures+=", ";
            }
        }
        return Figures;
    }

}
