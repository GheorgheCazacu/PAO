package com.fmi.store;

public class StringMain {


    public static void main(String[] args) {

        String firstString = "Ala bala portocala\n" +
                "To be, or not to be, that is the question:\n" +
                "Whether 'tis nobler in the mind to suffer\n" +
                "The slings and arrows of outrageous fortune,\n" +
                "Or to take arms against a sea of troubles\n";


        int i = firstString.indexOf(" ");
        System.out.println("index: " + i);

        String[] words = firstString.split(" ");

        for (String word : words) {
            System.out.println(word);
        }

        String email = "a@a.com";
        System.out.println("match: "
                + email.matches("[a-z.]\\@[a-z.]\\.com"));


        StringBuilder stringBuilder = new StringBuilder("");

        stringBuilder.append("prima linie \n")
                .append("a doua linie \n");

        System.out.println("stringBuilder" + stringBuilder.toString());

        System.out.println("stringBuilder 2: "
                + new String(stringBuilder));
    }


}
