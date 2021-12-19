package com.kodilla.patterns2.observer.homework;

import java.util.LinkedList;

public class Mentor implements Observer{
    private final String name;

    public Mentor(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public void update(Task task, LinkedList<Task> tasks) {
        System.out.println(name + " ma nowe zadanie do sprawdzenia: "+task.getName() +"\n"
                    +"Liczba wszystkich zadań: "+tasks.size());
    }
}
