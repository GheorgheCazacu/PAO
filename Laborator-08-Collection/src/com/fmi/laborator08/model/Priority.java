package com.fmi.laborator08.model;

public enum Priority {
    LOW(0), MEDIUM(1), HIGH(2), CRITICAL(3);
    private int priorityVal;

    public int getPriorityVal() {
        return priorityVal;
    }

    Priority(int priorityVal) {
        this.priorityVal = priorityVal;
    }
}
