package com.fmi.lab2.arrays;

import java.util.Arrays;

public class ArraysMain {

    public static void main(String[] args) {


        // tablou de intregi
        Integer[] arr = {4, 6, 7};

        // parcurgerea folosind pozitia elementului, index
        for (int i = 0; i < arr.length; i++) {
            System.out.println("i : " + arr[i]);
        }

        // parcurgerea lui folosind un foreach iterator
        for (Integer i : arr) {
            System.out.println("arr: " + i);
        }


        // alte forme de declarare
        String arrs[] = {"cuvant unu", "cuvant doi", "cuvant trei"};

        // old fashion, old school
        String arrn[] = new String[]{"new string", "second string"};

        printArray(arr);


        // array access using iterator
        System.out.println("array access using iterator");
        for (Integer i : arr) {
            System.out.println("arr: " + i);
        }

        Integer[][] a = {{1, 2, 3}, {4, 5, 6}};
        Integer[][] b = {{1, 2, 3}, {4, 5, 6}};

        for (int i = 0; i < a.length; i++) {
            Integer[] row = a[i];
            System.out.println("row: " + row);
            for (int j = 0; j < row.length; j++) {
                System.out.println("row[" + j + "] = " + row[j]);
                System.out.println("b[" + i + ", " + j + "] = " + b[i][j]);

            }
        }


    }

    /**
     * task 1, "generic"
     * @param array
     */
    public static void printArray(Object[] array) {
        if (array != null) {
            System.out.print("[ ");
            boolean first = true;
            for (Object obj : array) {
                if(first) {
                    first = false;
                } else {
                    System.out.print(", ");
                }
                System.out.print(obj);
            }
            System.out.println("]");
        }
    }


    /**
     *
     * @param array
     */
    public static void printArray(Integer[] array) {
        if (array != null) {
            System.out.print("[ ");
            boolean first = true;
            for (Integer obj : array) {
                if(first) {
                    first = false;
                } else {
                    System.out.print(", ");
                }
                System.out.print(obj);
            }
            System.out.println("]");
        }
    }

    /**
     * task 2
     */
    public static void  arraysStuff() {

        // tablou de intregi
        Integer[] arr = {4, 6, 7};

        Integer[][] a = {{1, 2, 3}, {4, 5, 6}};

        System.out.println("arrays: " + Arrays.toString(arr));


        for (int i = 0; i < a.length; i++) {
            System.out.println("arrays, row " + i + " : " + Arrays.toString(a[i]));
        }

        Integer myIntegerTable[] = {null, null, null};
        Arrays.fill(myIntegerTable, 12); // umplere a tuturor elementelor cu acelasi elemnt 12
        Arrays.sort(arr);

        String[] arraySearch = {"ala", "bala", "portocala", "pestisor"};

        int searchResult = Arrays.binarySearch(arraySearch, "bala");

        System.out.println("search wordk bala, result: " + searchResult);

        System.out.println("if result is -1, nothing was found!");



    }

}
