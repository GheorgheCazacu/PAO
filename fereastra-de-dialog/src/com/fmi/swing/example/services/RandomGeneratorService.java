package com.fmi.swing.example.services;


import com.fmi.swing.example.exceptions.YearException;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class RandomGeneratorService {

    private static final List<String> FIRST_NAMES = new ArrayList<>();
    private static final List<String> LAST_NAMES  = new ArrayList<>();

    private static RandomGeneratorService ourInstance = new RandomGeneratorService();
    public static RandomGeneratorService getInstance() {
        return ourInstance;
    }


    private static final Random RANDOM = new Random(22);



    private RandomGeneratorService() {
        //TODO change the paths to your appropriate needs ...

        Path path = Paths.get("./resources/first_names.txt");
        FIRST_NAMES.addAll(readLinesFromFile(path));

        path = Paths.get("./resources/last_names.txt");
        LAST_NAMES.addAll(readLinesFromFile(path));

    }


    /**
     * get a random name based of the input from resources folder
     * @return
     */
    public String getRandomName() {

        StringBuilder stringBuilder = new StringBuilder("");
        stringBuilder.append(FIRST_NAMES.get( RANDOM.nextInt(FIRST_NAMES.size())));
        stringBuilder.append(" ");
        stringBuilder.append(LAST_NAMES.get( RANDOM.nextInt(LAST_NAMES.size())));

        return stringBuilder.toString();
    }

    /**
     *
     * @param start
     * @param end
     * @return
     */
    public Date getRandomDateBetween(Date start, Date end) {
        long interval = (end.getTime() - start.getTime()) / (1000 * 60 * 60 * 24);
        int position = RANDOM.nextInt((int)interval);

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(start);
        calendar.add(Calendar.DATE , position);

        return calendar.getTime();
    }


    /**
     * return a date between start, end years
     * years between 1970 and 2018
     * @param startYear
     * @param endYear
     * @return
     */
    public Date getRandomDateBetween(Integer startYear, Integer endYear) throws YearException {
        if (startYear < 1970 || endYear < 1970) {
            throw new YearException("start or end year before 1970");
        }
        if (startYear > 2018 || endYear > 2018) {
            throw new YearException("start or end year after 2018");
        }
        if (startYear > endYear) {
            throw new YearException("start year is smaller than end year");
        }

        Calendar calendar = Calendar.getInstance();
        calendar.set(startYear, 0, 1, 0, 0, 0);
        Date startDate = calendar.getTime();

        calendar.set(endYear, 11, 31);
        Date endDate = calendar.getTime();

        return getRandomDateBetween(startDate, endDate);
    }


    private List<String> readLinesFromFile(Path path) {
        return readLinesFromFile(path.toAbsolutePath().toFile().getAbsolutePath());
    }

    /**
     * read a text file and return the lines as List<String>
     * we have also structure that return getLines, still this can
     * be easily updated to perform csv computation
     * @param fileNamePath
     * @return
     */
    private List<String> readLinesFromFile(String fileNamePath) {
        List<String> result = new ArrayList<>();
        BufferedReader bufferedReader = null;
        try {
            bufferedReader =
                    new BufferedReader(new FileReader(new File(fileNamePath)));
            String line = bufferedReader.readLine();

            while ( line != null) {
                result.add(line);
                line = bufferedReader.readLine();
            }

        } catch (FileNotFoundException exc) {
            exc.printStackTrace();
        } catch (IOException exc) {
            exc.printStackTrace();
        } finally {
            try {
                if(bufferedReader != null) {
                    bufferedReader.close();
                }
            } catch (IOException exc) {
                exc.printStackTrace();
            }
        }
        return result;
    }


}
