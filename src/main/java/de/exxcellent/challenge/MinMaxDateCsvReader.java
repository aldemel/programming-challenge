package de.exxcellent.challenge;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import com.opencsv.bean.CsvToBeanBuilder;
import org.apache.commons.beanutils.ConversionException;

public class MinMaxDateCsvReader {

    static List<MinMaxBean> getMinMaxDates(Class<? extends MinMaxBean> clazz, String filename) {

        try {
            return new CsvToBeanBuilder<MinMaxBean>(new FileReader(filename))
                    .withType(clazz)
                    .build()
                    .parse();
        } catch (FileNotFoundException ex) {
            System.out.println("Could not find file " + filename + ".");
        }
        catch (ConversionException ex) {
            System.out.println("Input string cannot be converted to int conversion");
        }
        return new ArrayList<>();
    }
}
