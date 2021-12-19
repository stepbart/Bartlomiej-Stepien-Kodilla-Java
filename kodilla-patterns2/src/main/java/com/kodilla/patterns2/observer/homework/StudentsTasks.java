package com.kodilla.patterns2.observer.homework;

import java.util.LinkedList;
import java.util.Queue;

public class StudentsTasks implements Observable{
    private final Observer mentor;
    private LinkedList<Task> tasks;

    public StudentsTasks(Observer mentor) {
        this.mentor = mentor;
        tasks = new LinkedList<>();
    }

    public Queue<Task> getTasks() {
        return tasks;
    }

    public void addTask(Task task){
        tasks.addLast(task);
        notifyMentor();
    }

    @Override
    public void notifyMentor() {
        mentor.update(tasks.getLast(),tasks);
    }
}
