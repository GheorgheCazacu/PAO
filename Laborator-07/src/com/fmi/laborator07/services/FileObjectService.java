package com.fmi.laborator07.services;

import java.io.*;

/**
 * singleton class to help serialize objects on your drives
 */
public class FileObjectService {

    private static FileObjectService ourInstance = new FileObjectService();

    public static FileObjectService getInstance() {
        return ourInstance;
    }

    private FileObjectService() {
    }

    /**
     * write an object which is serializable
     * @param serObj
     * @param filepath
     */
    public void writeObjectToFile(Object serObj, String filepath) {

        try {
            FileOutputStream fileOut = new FileOutputStream(filepath);
            ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
            objectOut.writeObject(serObj);
            objectOut.close();
            System.out.println("The Object was successfully written to a file");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    /**
     * read an object from the file, if the class is not in class path throws an exception
     * the returned result is Object, you need to perform a cast
     * @param filepath
     * @return
     */
    public Object readObjectFromFile(String filepath) {
        Object result = null;
        try {
            FileInputStream fis = new FileInputStream(filepath);
            ObjectInputStream ois = new ObjectInputStream(fis);
            result = ois.readObject();
            ois.close();
            System.out.println("The Object was successfully read from the file");
            System.out.println("The Object class is: " + result.getClass().getCanonicalName());


        } catch (IOException exc) {
            exc.printStackTrace();
        } catch (ClassNotFoundException exc) {
            exc.printStackTrace();
        }


        return result;
    }


}
