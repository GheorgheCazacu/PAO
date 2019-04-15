package com.fmi.laborator08.model;

public enum Grade {

    Junior("0"), Medium("1"), Senior("2");

    private String grade;

    Grade(String grade) {
        this.grade = grade;
    }

    public String getGrade() {
        return grade;
    }
}
