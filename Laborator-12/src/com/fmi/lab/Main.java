package com.fmi.lab;

import com.fmi.lab.models.User;
import com.fmi.lab.services.UserService;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
	// write your code here


        List<User> userList = UserService.getInstance().findAll();

//        userList.forEach(System.out::println);

        List<Integer> integerList = new ArrayList<>();

        for(int i = 0; i < 200; i++) {
            integerList.add(i);
        }

        integerList.parallelStream().forEach(System.out::println);

        Calendar calendar = Calendar.getInstance();
        calendar.set(1990, 0, 1);

        System.out.println(userList.parallelStream()
                .filter(x -> (x.getDateOfBirth().before(calendar.getTime())))
                .limit(6).collect(Collectors.toList()));


    }
}
