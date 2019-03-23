package com.fmi.laborator.geometric;

public class Square extends Rectangle {

    public Square(Double side) {
        super(side, side);
    }

    public Double getSide() {
        return this.getSideA();
    }

}
