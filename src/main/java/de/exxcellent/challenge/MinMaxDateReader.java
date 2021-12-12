package de.exxcellent.challenge;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;
import com.opencsv.bean.CsvToBeanBuilder;

public class MinMaxDateReader {

    static List<WeatherDate> getWeatherDates(String filename) throws FileNotFoundException {
        List<WeatherDate> beans = new CsvToBeanBuilder(new FileReader(filename))
                .withType(WeatherDate.class).build().parse();
        return beans;
    }
}
