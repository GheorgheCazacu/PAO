package com.fmi.lab2;

import com.fmi.lab2.animals.Cat;
import com.fmi.lab2.animals.Dog;

public class Main {

    public static void main(String[] args) {
	// write your code here

        //animals region

        Cat cat = new Cat();
        // prop default outside package is invisible

        // dog getters and setters are public, so are visible everywhere.
        Dog dog = new Dog();
        dog.setSize(2);

    }
}
