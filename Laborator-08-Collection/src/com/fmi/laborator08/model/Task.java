package com.fmi.laborator08.model;

import java.util.Objects;

public class Task {

    private String name;
    private double timeEstimation;
    private  Priority priority;

    public Task(String name, double timeEstimation, Priority priority) {
        this.name = name;
        this.timeEstimation = timeEstimation;
        this.priority = priority;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getTimeEstimation() {
        return timeEstimation;
    }

    public void setTimeEstimation(double timeEstimation) {
        this.timeEstimation = timeEstimation;
    }

    public Priority getPriority() {
        return priority;
    }

    public void setPriority(Priority priority) {
        this.priority = priority;
    }

    @Override
    public String toString() {
        return "Task{" +
                "name='" + name + '\'' +
                ", timeEstimation=" + timeEstimation +
                ", priority=" + priority +
                '}';
    }
}
