package com.fmi.laborator08.model;

public enum Grade {
    Junior(0), Medium(1), Senior(2);
    private int grade;

    Grade(int grade) {
        this.grade = grade;
    }

    public int getGrade() {
        return grade;
    }
}
