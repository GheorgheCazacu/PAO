package com.fmi.laborator6;

public enum DAY {
    SUNDAY(0), MONDAY(1), TUESDAY(2), WEDNESDAY(3),
    THURSDAY(4), FRIDAY(4), SATURDAY(5);

    private int position;

    DAY(int position) {
        this.position = position;
    }

    public int getPosition() {
        return position;
    }
}
