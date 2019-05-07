package com.fmi.proiect;

import com.fmi.proiect.services.AuditLogService;
import com.sun.jmx.snmp.tasks.ThreadService;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class Main {

    static Object lock = new Object();
    static ReadWriteLock readWriteLock = new ReentrantReadWriteLock();

    public static void main(String[] args) {
	// write your code here

//        AuditLogService.getInstance().writeLogLine("msg 1");
//
//        AuditLogService.getInstance().writeLogLine("msg 2");



        Thread thread = new Thread() {

            @Override
            public void run() {
                System.out.println("my thread is: " + Thread.currentThread().getName());
            }
        };

        thread.run();
        thread.start();

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("runnable my thread is: " + Thread.currentThread().getName());
            }
        };

        Thread t = new Thread(runnable);
        t.start();

        ExecutorService executorService = Executors.newFixedThreadPool(3);

        for(int i = 1; i < 11; i++) {
            executorService.submit(runnable);
        }

        executorService.shutdown();


        List<Integer> myList = new ArrayList<>();
        for(int i=0; i < 100; i++) {
            myList.add(i);
        }

        myList.parallelStream().forEach(System.out::println);


    }
}
