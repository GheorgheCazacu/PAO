package com.fmi.store.models;

public abstract class Product implements Cloneable {

    private Category category;
    private Price price;
    private String name;
    private String smallDescription;

    public Product(final Category category, final Price price, String name, String smallDescription) {
        try {
            // copy the mutable param
            this.category = (Category) category.clone();
            this.price = price.clone(); // override of clone method
            // using a return of type Price which is inherited from Object, this means is allowed

        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        this.name = name;
        this.smallDescription = smallDescription;
    }

    // strange behavior in java
    // you can have a method with the same name at the class name
    // and looks like a constructor but it isn't, just good to know
    public Product Product() {
        return null;
    }

    public Category getCategory() {
        Category result = null;
        try {
            if(category != null) {
                result = (Category)category.clone();
            }
        } catch (CloneNotSupportedException exc) {
            exc.printStackTrace();
        }

        return result;
    }

    // setter is inherited by FoodProduct, this means need to be erase for FoodProduct to be immutable
//    public void setCategory(Category category) {
//        this.category = category;
//    }

    public Price getPrice() {
        Price result = null;
        try {
            if(price != null) {
                result = price.clone();
            }
        } catch (CloneNotSupportedException exc) {
            exc.printStackTrace();
        }
        return result;
    }

    // setter is inherited by FoodProduct, this means need to be erase for FoodProduct to be immutable
//    public void setPrice(Price price) {
//        this.price = price;
//    }

    public String getName() {
        return name;
    }

//    public void setName(String name) {
//        this.name = name;
//    }

    public String getSmallDescription() {
        return smallDescription;
    }

    // setter is inherited by FoodProduct, this means need to be erase for FoodProduct to be immutable
//    public void setSmallDescription(String smallDescription) {
//        this.smallDescription = smallDescription;
//    }

    @Override
    public String toString() {

        StringBuilder stringBuilder = new StringBuilder("");
        stringBuilder.append("Product{category=").append(category).append(", price=").append(price)
                .append(", name='").append(name).append("', smallDescription='").append(smallDescription)
                .append("'}");


        return stringBuilder.toString();
    }

    @Override
    public Product clone() throws CloneNotSupportedException {
        // change also the returned object, now it isn't needed the cast in class Main
        // fix clone for category, I miss that at class

        Product newObject = (Product)super.clone();
        if(this.category != null) {
            try {
                newObject.category = ((Category) this.category.clone());
            } catch (CloneNotSupportedException exc) {
                exc.printStackTrace();
            }
        }
        if(this.price != null) {
            try {
                newObject.price = (this.price.clone());
            } catch (CloneNotSupportedException exc) {
                exc.printStackTrace();
            }
        }
        return newObject;
    }

    @Override
    protected void finalize() throws Throwable {
        System.out.println("finalize for producat : " + this.name);
        super.finalize();
    }
}
