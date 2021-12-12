package de.exxcellent.challenge;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;

import com.opencsv.bean.CsvToBeanBuilder;

public class MinMaxDateReader {

    static List<MinMaxBean> getMinMaxDates(Class clazz, String filename) throws FileNotFoundException {
        List<MinMaxBean> beans = new CsvToBeanBuilder(new FileReader(filename))
                .withType(clazz)
                .build()
                .parse();
        return beans;
    }
}
