package de.exxcellent.challenge;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;

import com.opencsv.bean.CsvToBeanBuilder;

public class MinMaxDateCsvReader {

    static List<MinMaxBean> getMinMaxDates(Class clazz, String filename) throws FileNotFoundException {
        return new CsvToBeanBuilder(new FileReader(filename))
                .withType(clazz)
                .build()
                .parse();
    }
}
