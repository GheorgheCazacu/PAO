package com.fmi.laborator07.services;

import java.io.*;

public class FileObjectSerializableService {
    private static FileObjectSerializableService ourInstance = new FileObjectSerializableService();

    public static FileObjectSerializableService getInstance() {
        return ourInstance;
    }

    private FileObjectSerializableService() {
    }


    /**
     * object needs to implement serializable
     * @param object
     * @param fileNamePath
     */
    public void writeObjectToFile(Object object, String fileNamePath) {


        try {
            ObjectOutputStream objectOutputStream =
                    new ObjectOutputStream(new FileOutputStream(fileNamePath));
            objectOutputStream.writeObject(object);

            objectOutputStream.flush();
            objectOutputStream.close();

        } catch (IOException e) {
            e.printStackTrace();
        }


    }


    public Object readObjectFromFile(String fileNamePath) {
        Object object = null;

        try {
            ObjectInputStream objectInputStream =
                    new ObjectInputStream(new FileInputStream(fileNamePath));

            object = objectInputStream.readObject();

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return object;
    }

}
