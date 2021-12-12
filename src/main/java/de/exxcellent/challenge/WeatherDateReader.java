package de.exxcellent.challenge;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import com.opencsv.CSVReader;

public class WeatherDateReader {

    static List<WeatherDate> getDates(String fileName) throws FileNotFoundException {
        CSVReader reader = new CSVReader(new FileReader(fileName));
        String line[];
        Iterator it = reader.iterator();
        ArrayList<WeatherDate> dates = new ArrayList<>();
        line = (String[]) it.next();
        System.out.println("first line: " + Arrays.toString(line));
        System.out.println(" ");
        while (it.hasNext()) {
            line = (String[]) it.next();
            System.out.println(Arrays.toString(line));
            WeatherDate date = new WeatherDate(line[0], Integer.parseInt(line[1]), Integer.parseInt(line[2]));
            dates.add(date);
        }
        return dates;
    }

}
