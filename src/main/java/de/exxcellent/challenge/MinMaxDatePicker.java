package de.exxcellent.challenge;

import java.io.FileNotFoundException;
import java.util.List;

public class MinMaxDatePicker {
    private List<MinMaxBean> dates;
    public MinMaxDatePicker(Class clazz, String filename) throws FileNotFoundException {
        this.dates = MinMaxDateReader.getMinMaxDates(clazz, filename);
    }

    public String getDateWithSmallestSpread() {
        int smallestSpread = dates.get(0).getSpread();
        String dateWithSmallestSpread = dates.get(0).getLineKey();
        for (MinMaxBean date : dates) {
            int spread = date.getSpread();
            if (spread < smallestSpread) {
                smallestSpread = spread;
                dateWithSmallestSpread = date.getLineKey();
            }
        }
        return dateWithSmallestSpread;
    }
}
