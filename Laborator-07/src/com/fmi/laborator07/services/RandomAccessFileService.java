package com.fmi.laborator07.services;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class RandomAccessFileService {
    private static RandomAccessFileService ourInstance = new RandomAccessFileService();

    public static RandomAccessFileService getInstance() {
        return ourInstance;
    }

    private RandomAccessFileService() {
    }


    public void performTask(String fileNamePath) {

        try {
            RandomAccessFile randomAccessFile = new RandomAccessFile(fileNamePath, "rw");
            System.out.println("file length: " + randomAccessFile.length());


            int numberLines = 0;

            for(long position = (randomAccessFile.length() - 1); position > -1; position--) {
                randomAccessFile.seek(position);
                int readNumber = randomAccessFile.readByte();
                if(readNumber == 10 || readNumber == 13){
                    numberLines = randomAccessFile.readInt();
                    System.out.println(numberLines);
                    break;

                }
            }

            randomAccessFile.seek(6);
            randomAccessFile.writeUTF("other text");

//            for(int i = 1; i <= numberLines; i++) {
//                System.out.println("line = " + randomAccessFile.readLine());
//            }

            randomAccessFile.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
