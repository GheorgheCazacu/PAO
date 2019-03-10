package com.fmi.lab2.animals;

public class AnimalsMain {
    public static void main(String[] args) {

        Cat cat = new Cat();

        // field default
        cat.propDefault = 4;

        // public method
        cat.meow();

        // field protected
        cat.shortHair = false;

        // cat private members are invisible


    }
}
