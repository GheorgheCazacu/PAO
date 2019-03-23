package com.fmi.laborator.geometric;

public class Triangle implements Shape{

    private Double sideA;
    private Double sideB;
    private Double sideC;

    public Triangle(Double sideA, Double sideB, Double sideC) {
        this.sideA = sideA;
        this.sideB = sideB;
        this.sideC = sideC;
    }

    public Double getSemiPerimeter() {
        Double result = null;
        if(sideA != null && sideB != null && sideC != null) {
            result = (sideA + sideB + sideC) / 2;
        }
        return result;
    }

    @Override
    public Double getArea() {
        Double result = null;
        // somehow cryptic, please don't do this as daily activities
        result = getSemiPerimeter();
        if(result != null) {
            result = Math.sqrt(result * (result - sideA) * (result - sideB) * (result - sideC));
        }
        return result;
    }

    @Override
    public Double getPerimeter() {
        Double result = null;
        if(sideA != null && sideB != null && sideC != null) {
            result = sideA + sideB + sideC;
        }
        return result;
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

    public Double getSideC() {
        return sideC;
    }

    public void setSideC(Double sideC) {
        this.sideC = sideC;
    }
}
