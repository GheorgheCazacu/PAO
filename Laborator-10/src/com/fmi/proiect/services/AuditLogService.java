package com.fmi.proiect.services;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

public class AuditLogService {

    private static PrintWriter printWriter;
    private static final String LOG_LOCATION = "./audit.log";

    private static AuditLogService ourInstance = new AuditLogService();

    public static AuditLogService getInstance() {
        return ourInstance;
    }

    private AuditLogService() {

        try {
            printWriter = new PrintWriter(new File(LOG_LOCATION));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        Runtime.getRuntime().addShutdownHook(new Thread() {
            @Override
            public void run() {
               closeWriter();
            }
        });
    }

    public void writeLogLine(String message) {

            Date d = new Date();
            printWriter.println(message + "," + d);

    }

    private boolean closeWriter () {
        boolean result = true;
        printWriter.flush();
        printWriter.close();
        return result;
    }

}
