package com.kodilla.patterns.factory.tasks;

public class TaskDraft implements Task {

    private String taskName;
    private boolean isComplete;

    public TaskDraft(String taskName) {
        this.taskName = taskName;
        this.isComplete = false;
    }

    public void markAsCompleted(){
        this.isComplete = true;
    }

    @Override
    public void executeTask() {
        markAsCompleted();
    }

    @Override
    public String getTaskName() {
        return taskName;
    }

    @Override
    public boolean isTaskExecuted() {
        return isComplete;
    }
}
