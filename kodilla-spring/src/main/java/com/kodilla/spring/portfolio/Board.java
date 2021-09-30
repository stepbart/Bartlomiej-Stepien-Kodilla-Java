package com.kodilla.spring.portfolio;

import org.springframework.stereotype.Component;

@Component
public class Board {
    private TaskList toDoList;
    private TaskList inProgressList;
    private TaskList doneList;

    public Board() {
        this.toDoList = new TaskList();
        this.inProgressList = new TaskList();
        this.doneList = new TaskList();
    }

    public void showLists(){
        System.out.println(toDoList+": "+toDoList.getTask());
        System.out.println(inProgressList+": "+inProgressList.getTask());
        System.out.println(doneList+": "+doneList.getTask());
    }

    public void addTaskToDo(String task){
        toDoList.addTask(task);
    }
    public void addTaskToProgress(String task){
        inProgressList.addTask(task);
    }

    public void addDoneTask(String task){
        doneList.addTask(task);
    }
}
