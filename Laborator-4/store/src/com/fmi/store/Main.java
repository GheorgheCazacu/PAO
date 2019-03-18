package com.fmi.store;

import com.fmi.store.models.*;

import java.util.Date;

public class Main {


    public static void main(String[] args) {


        FoodProduct foodProduct = new FoodProduct(null, null, "name",
                "small description", new Date());
        // no setter or other change stuff
        //foodProduct

//        testStringBuffer();
    }

    public static void testStringMethods() {
        String string = "ala bala portocala";

        System.out.println("index of: " + string.indexOf("bala"));


    }

    public static void testStringCreation() {

        String string = "my first string";
        String otherString = new String("other string");
        String thirdString = string + ", " + otherString;

        System.out.println("third: " + thirdString);

        // search for a string in a string
        int i = thirdString.indexOf(", ");
        System.out.println("find \", \" at position: " + i);

        // search for a char in a string, instead of double quote we have simple quotes
        System.out.println("find ','  at position: " + thirdString.indexOf(','));

        // substring start from a positiion till the end
        String forthString = thirdString.substring(i + 2);
        System.out.println("forthString: " + forthString);

        // begin, end -  stop at a defined end
        forthString = thirdString.substring(i + 2, i + 2 + 5);
        System.out.println("forthString: " + forthString);

        // begin, end -  stop at a defined end after real end,
        // will result in an exception Exception in thread "main" java.lang.StringIndexOutOfBoundsException: String index out of range
//        forthString = thirdString.substring(i + 2, i + 2 + 5 + 25);
        System.out.println("forthString: " + forthString);

        // String create from StringBuilder
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("un string urmat de un integer: ").append(22).append(", apoi de un caracter").append(';');
        String fifthString = new String(stringBuilder);
        System.out.println("fifthString: " + fifthString);
        // or
        System.out.println("stringBuilder: " + stringBuilder.toString());

        // the same is working for StringBuffer


        // new for new string's
        String s1 = "un string";
        String s2 = "un string";
        String s3 = new String("un string");

        System.out.println("s1 == s2 :"+(s1==s2));
        System.out.println("s1 == s3 :"+(s1==s3));
        //        output
        //        s1 == s2 :true
        //        s1 == s3 :false


    }

    public static void testStringBuffer() {
//        User user = new User(1, "username-1", "my-password");
//        System.out.println("user = " + user);
//
//        Product product = new Product(new Category("category name", "categ desc", null),
//                null, "product name", "product description");
//        System.out.println("product = " + product);
    }

    public static void testImutable() {

//        Product product = new Product(new Category("category name", "categ desc", null),
//                null, "product name", "product description");


    }

    public static void doStuff() {
        // code from previous lab


        User user1 = new User(24, "username", "password");
        User user2 = new User(24, "usernamesdadsa", "password");

        System.out.println("user1 == user2 : " + (user1 == user2));
        System.out.println("user1.equals( user2) : " + (user1.equals(user2)));


        Category category = new Category("category 1",
                "description 1", null);

//        Product product = new Product(category, null,
//                "produs name", "produs description");
//
//        Product foodProduct = new FoodProduct(category, null,
//                "food product name", "food product description", null);
//
//        System.out.println("product getName : " + product.getName());
//        System.out.println("foodProduct getName : " + foodProduct.getName());
//
//        try {
//            Product productDuplicate = (Product)foodProduct.clone();
//            System.out.println("productDuplicate: " + productDuplicate);
//        } catch (CloneNotSupportedException exc) {
//            exc.printStackTrace();
//        }
    }

}
