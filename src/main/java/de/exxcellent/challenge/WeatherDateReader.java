package de.exxcellent.challenge;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.opencsv.CSVReader;

public class WeatherDateReader {

    static List<WeatherDate> getWeatherDates(String fileName) {
        ArrayList<WeatherDate> dates = new ArrayList<>();
        try {
            CSVReader reader = new CSVReader(new FileReader(fileName));
            String line[];
            Iterator it = reader.iterator();
            it.next(); //skip first
            while (it.hasNext()) {
                line = (String[]) it.next();
                WeatherDate date = new WeatherDate(line[0], line[1], line[2]);
                dates.add(date);
            }
        }
        catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }
        return dates;
    }

}
