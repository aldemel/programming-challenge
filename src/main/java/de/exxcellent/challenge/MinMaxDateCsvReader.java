package de.exxcellent.challenge;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.bean.exceptionhandler.ExceptionHandlerQueue;
import org.apache.commons.beanutils.ConversionException;

public class MinMaxDateCsvReader {

    static List<MinMaxBean> getMinMaxDates(Class<? extends MinMaxBean> clazz, String filename) {

        try {
            var csvBuilder = new CsvToBeanBuilder<MinMaxBean>(new FileReader(filename))
                    .withType(clazz)
                    .withExceptionHandler(new ExceptionHandlerQueue())
                    .build();

            var parsed = csvBuilder.parse();
            for (var ex : csvBuilder.getCapturedExceptions())
            {
                System.out.println("Line number " + ex.getLineNumber() + " of csv file could not be parsed.");
                System.out.print("Line: ");
                System.out.println(Arrays.stream(ex.getLine()).collect(Collectors.toList()));
            }
            return parsed;
        }
        catch (FileNotFoundException ex) {
            System.out.println("Could not find file " + filename);
        }
        return new ArrayList<>();
    }
}
