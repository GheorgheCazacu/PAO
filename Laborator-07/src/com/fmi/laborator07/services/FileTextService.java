package com.fmi.laborator07.services;

import com.fmi.laborator07.models.User;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FileTextService {
    private static FileTextService ourInstance = new FileTextService();

    public static FileTextService getInstance() {
        return ourInstance;
    }

    private FileTextService() {
    }


    public void writeTextToFile (String textToWrite, String fileNamePath) {

        try {
            PrintWriter printWriter = new PrintWriter(
                    new FileOutputStream(fileNamePath));

            printWriter.println(textToWrite);

            printWriter.flush();
            printWriter.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     *
     * @param fileNamePath
     * @return
     */
    public User readUserFromFile(String fileNamePath) {
        User user = null;
        try {

            LineNumberReader lineNumberReader = new LineNumberReader(
                    new FileReader(fileNamePath));

            String line = lineNumberReader.readLine();
            String[] values = line.split(",");
            SimpleDateFormat simpleDateFormat =
                    new SimpleDateFormat("dd/MM/yyyy");
            user = new User(values[0], simpleDateFormat.parse(values[2]), values[1]);
            lineNumberReader.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return user;
    }


}
