package com.fmi.laborator08;

import com.fmi.laborator08.model.Employee;
import com.fmi.laborator08.model.Grade;
import com.fmi.laborator08.model.Priority;
import com.fmi.laborator08.model.Task;

import java.util.*;

public class Main {

    public static void main(String[] args) {


        List<Employee> employees = new LinkedList<>();

        long start = (new Date()).getTime();

        for(int i = 0; i < 1_00_0_00_0; i++) {

            employees.add(new Employee("username" + i, "pass",
                    new Long(i), "name", Grade.Medium));

        }

        System.out.println("time spent: " + ((new Date()).getTime() - start));


    }


    public static void doStuffMap() {

        Map<String, Integer> hashMap = new LinkedHashMap<>();


        String inputText = "ala bala portocala a2t lol34 like " +
                "light locos 23 55 1 af";

        String[] words = inputText.split(" ");

        for(String word : words) {

            if(word.matches("[0-9]*")) {
                if(hashMap.get("numeric") != null) {
                    hashMap.put("numeric", hashMap.get("numeric") + 1);
                } else {
                    hashMap.put("numeric", 1);
                }
                continue;
            }

            if(word.matches("[a-zA-Z]*")) {
                if(hashMap.get("alpha") != null) {
                    hashMap.put("alpha", hashMap.get("alpha") + 1);
                } else {
                    hashMap.put("alpha", 1);
                }
                continue;
            }

            if(word.matches("[a-zA-Z0-9]*")) {
                if(hashMap.get("alphanumeric") != null) {
                    hashMap.put("alphanumeric", hashMap.get("alphanumeric") + 1);
                } else {
                    hashMap.put("alphanumeric", 1);
                }
                continue;
            }
        }

        for(String key : hashMap.keySet()) {
            System.out.println(key + " = " + hashMap.get(key));
        }


    }


    public static void doStuffLists(){


        List<Task> tasks = new ArrayList<>();

        Random random = new Random(40);

        for(int i = 0; i < 10; i++) {

            double timeEstimation = 40 * random.nextDouble();

            Task task = new Task("Task-" + i, timeEstimation, Priority.HIGH);

            tasks.add(task);

        }

        tasks.get(2).setPriority(Priority.CRITICAL);
        tasks.get(5).setPriority(Priority.LOW);
        tasks.get(7).setPriority(Priority.MEDIUM);
        tasks.get(4).setPriority(Priority.MEDIUM);


        Comparator<Task> taskComparator = new Comparator<Task>() {
            @Override
            public int compare(Task o1, Task o2) {

                int result = (int)(o2.getPriority().getPriorityVal()
                        - o1.getPriority().getPriorityVal());

                if( result == 0) {
                    result = (int)(o1.getTimeEstimation() - o2.getTimeEstimation());
                }

                return result;
            }
        };

        Collections.sort(tasks, taskComparator);

        for(Task t : tasks) {
            System.out.println(t);
        }


    }
}
