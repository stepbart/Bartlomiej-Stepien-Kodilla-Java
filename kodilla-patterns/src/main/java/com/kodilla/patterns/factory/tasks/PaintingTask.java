package com.kodilla.patterns.factory.tasks;

public class PaintingTask extends TaskDraft {

    private String color;
    private String whatToPaint;

    public PaintingTask(String taskName, String color, String whatToPaint){
        super(taskName);
        this.color = color;
        this.whatToPaint = whatToPaint;
    }

}
