package com.fmi.lab1;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here

//        System.out.println("primul string " + 554.76776);

        Scanner scanner = new Scanner(System.in);

//        System.out.println("introduceti un integer");
//        while (scanner.hasNext()) {
//
//            System.out.println("word: " + scanner.nextInt());
//            System.out.println("introduceti un integer");
//
//        }


//        for (int i = 0; i < 5; i++) {
//            System.out.println("introduceti un integer");
//            System.out.println("integer-ul introdus este: " + scanner.nextInt());
//
//
//        }


//        while (scanner.hasNext()) {
//            System.out.println("introduceti un integer");
//            if (scanner.hasNextInt()) {
//                int i = scanner.nextInt();
//                System.out.println("integer-ul introdus este: " + i);
//            } else {
//                System.out.println("nu este un integer, parasesc bucla");
//                break;
//            }
//        }



        Scanner scannerFromString = new Scanner("primul al-doilea al-treilea");
        scannerFromString.useDelimiter(" ");

        do {

            String word = scannerFromString.next();

            switch (word) {
                case "primul":
                    System.out.println("acesta este primul cuvant");
                    break;
                case "al-doilea":
                    System.out.println("acesta este al doilea cuvant");
                    break;
                default:
                    System.out.println("acesta este un cuvant");
            }


        } while(scannerFromString.hasNext());














        scanner.close();


    }
}
