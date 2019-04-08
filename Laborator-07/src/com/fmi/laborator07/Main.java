package com.fmi.laborator07;

import com.fmi.laborator07.models.User;
import com.fmi.laborator07.services.FileObjectSerializableService;
import com.fmi.laborator07.services.FileSerializableService;
import com.fmi.laborator07.services.FileTextService;
import com.fmi.laborator07.services.RandomAccessFileService;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Properties;

public class Main {

    public static void main(String[] args) {

        Calendar calendar = Calendar.getInstance();
        calendar.set(1990, 2, 22);

        Date userBirtday = calendar.getTime();

        User user = new User("my user name -00", userBirtday,
                "my secret password");

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");


        StringBuilder stringBuilder = new StringBuilder("");
        stringBuilder.append(user.getName())
                .append(",").append(user.getHashPassword())
                .append(",").append(simpleDateFormat.format(user.getDateOfBirth()));


        FileTextService.getInstance().writeTextToFile(stringBuilder.toString(),
                "/Users/clyde/IdeaProjects/Laborator-07/files2/user.csv");

        User u = FileTextService.getInstance().readUserFromFile(
                "/Users/clyde/IdeaProjects/Laborator-07/files2/user.csv")  ;

        System.out.println(u);



    }



    public static void performPropertiesWork() {


        Properties properties = new Properties();

        try {
            properties.load(new FileInputStream(
                    "./files2/application.properties"));

            for( String propName : properties.stringPropertyNames()) {
                System.out.println("prop name = " + propName
                        + ", values = " + properties.getProperty(propName));
            }

            properties.put("newProp", "value of a new prop");

            properties.store(new FileOutputStream(
                    "./files2/application.properties"), "comentariu");

        } catch (IOException e) {
            e.printStackTrace();
        }

        Path pathSrc = Paths.get("./files2/application.properties");
        Path pathDest = Paths.get("./files2/application-copy.properties");

        try {
            Files.copy(pathSrc, pathDest);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    public static void stuff() {

        User user = new User("my user name -00", new Date(),
                "my secret password");


        FileSerializableService.getInstance().writeObjectToFile(user,
                "/Users/clyde/IdeaProjects/Laborator-07/files2/my-user-01.txt");


        User otherUser = (User) FileSerializableService.getInstance().readObjectFromFile(
                "/Users/clyde/IdeaProjects/Laborator-07/files2/my-user-01.txt");

        System.out.println(otherUser);
//        User user = new User("first user", new Date(), "my hash password");
//
//        FileObjectSerializableService.getInstance().writeObjectToFile(user,
//                "/Users/clyde/IdeaProjects/Laborator-07/files/user.txt");
//
//        User newUser = (User) FileObjectSerializableService.getInstance()
//                .readObjectFromFile("/Users/clyde/IdeaProjects/Laborator-07/files/user.txt");
//
//        System.out.println(newUser);

//        RandomAccessFileService.getInstance()
//                .performTask("/Users/clyde/IdeaProjects/Laborator-07/files/task2.txt");

//
//        Properties properties = new Properties();
//        try {
//
//            properties.load(new
//                    FileInputStream("/Users/clyde/IdeaProjects/Laborator-07/files/application.properties"));
//            for(String key : properties.stringPropertyNames()) {
//                System.out.println("key = " + key + ", valoare = " + properties.get(key));
//            }
//
//            properties.put("prop3", "value 3");
//
//            properties.store(new FileOutputStream("/Users/clyde/IdeaProjects/Laborator-07/files/application.properties"),
//                    "");
//
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

    }
}
