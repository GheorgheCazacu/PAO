package com.fmi.laborator08.services;

/**
 * reading and writing csv files business
 * two methods
 * readUsersFromFile
 * writeUsersToFile
 * internal method userToCSVLine get a User return a String (csv line)
 */
public class FileService {
    private static FileService ourInstance = new FileService();

    public static FileService getInstance() {
        return ourInstance;
    }

    private FileService() {
    }
}
