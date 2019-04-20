package com.fmi.laborator09.fx;

import com.fmi.laborator09.fx.services.UserService;

public class IgnoredApp {

    public static void main(String[] args) {

        UserService.getInstance().findAll().forEach(System.out::println);

    }
}
