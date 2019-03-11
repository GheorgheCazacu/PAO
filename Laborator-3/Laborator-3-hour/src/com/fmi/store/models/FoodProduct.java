package com.fmi.store.models;

public class FoodProduct extends Product{

    public FoodProduct(Category category, Price price, String name, String smallDescription) {
        super(category, price, name, smallDescription);
    }

    @Override
    public String getName() {
        return "FoodProduct - " + super.getName();
    }


}
