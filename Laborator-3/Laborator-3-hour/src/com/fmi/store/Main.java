package com.fmi.store;

import com.fmi.store.models.*;

public class Main {

    public static void main(String[] args) {
	// write your code here

        User user1 = new User(24, "username", "password");
        User user2 = new User(24, "usernamesdadsa", "password");

        System.out.println("user1 == user2 : " + (user1 == user2));
        System.out.println("user1.equals( user2) : " + (user1.equals(user2)));


        Category category = new Category("category 1",
                "description 1", null);

        Product product = new Product(category, null,
                "produs name", "produs description");

        Product foodProduct = new FoodProduct(category, null,
                "food product name", "food product description");

        System.out.println("product getName : " + product.getName());
        System.out.println("foodProduct getName : " + foodProduct.getName());

        try {
            Product productDuplicate = (Product)foodProduct.clone();
            System.out.println("productDuplicate: " + productDuplicate);
        } catch (CloneNotSupportedException exc) {
            exc.printStackTrace();
        }



    }
}
