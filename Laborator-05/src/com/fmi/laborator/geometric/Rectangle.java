package com.fmi.laborator.geometric;

public class Rectangle implements Shape {

    private Double sideA;
    private Double sideB;



    public Rectangle(Double sideA, Double sideB) {
        this.sideA = sideA;
        this.sideB = sideB;
    }

    public Double getSideA() {
        return sideA;
    }

    public void setSideA(Double sideA) {
        this.sideA = sideA;
    }

    public Double getSideB() {
        return sideB;
    }

    public void setSideB(Double sideB) {
        this.sideB = sideB;
    }

    @Override
    public Double getArea() {
        Double result = null;
        if(sideA != null && sideB != null)
            result = sideA * sideB;
        return result;
    }

    @Override
    public Double getPerimeter() {
        Double result = null;
        if(sideA != null && sideB != null)
            result = 2 * (sideA + sideB);
            return result;
    }
}
