package com.fmi.laborator09;


import com.fmi.laborator09.services.RandomGeneratorService;
import com.fmi.laborator09.services.UserService;

public class Main {

    public static void main(String[] args) {

        System.out.println("all the interesting swing components are in package com.fmi.laborator09.components!");

        UserService.getInstance().findAll().forEach(System.out::println);

    }
}
