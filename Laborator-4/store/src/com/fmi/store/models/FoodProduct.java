package com.fmi.store.models;

import java.util.Date;

public class FoodProduct extends Product {

    private Date foodExpirationDate;

    // in constructor make a copy for mutable data e.g. Date foodExpirationDate
    public FoodProduct(Category category, Price price, String name,
                       String smallDescription, Date foodExpirationDate) {
        super(category, price, name, smallDescription);
        this.foodExpirationDate = (Date)foodExpirationDate.clone();
    }

    @Override
    public String getName() {
        return "FoodProduct - " + super.getName();
    }

    /**
     * return a duplicate of the date in order to avoid date change => no immutable
     * @return
     */
    public Date getFoodExpirationDate() {
        Date result = null;
        if (foodExpirationDate != null) {
            result = (Date)foodExpirationDate.clone();
        }
        return result;
    }

    // no setter for immutable
//    public void setFoodExpirationDate(Date foodExpirationDate) {
//        this.foodExpirationDate = foodExpirationDate;
//    }
}
