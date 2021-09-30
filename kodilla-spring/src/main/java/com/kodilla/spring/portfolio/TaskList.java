package com.kodilla.spring.portfolio;

import java.util.ArrayList;
import java.util.List;

public class TaskList {
    private List<String> tasks;

    public TaskList() {
        tasks = new ArrayList<>();
    }

    public void addTask(String task){
        tasks.add(task);
    }

    public String getTask(){
        if (tasks.size()==0){
            return "Empty list";
        }
        else {
            return tasks.get(tasks.size()-1);
        }
    }

}
