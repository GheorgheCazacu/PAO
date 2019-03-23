package com.fmi.laborator.geometric;

public class TriangleScalene extends Triangle implements NamedObject{
    private String name;
    private String description;

    public TriangleScalene(String name, String description,
                           Double sideA, Double sideB, Double sideC) {
        super(sideA, sideB, sideC);
        this.name = name;
        this.description = description;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public String getDescription() {
        return this.description;
    }
}
