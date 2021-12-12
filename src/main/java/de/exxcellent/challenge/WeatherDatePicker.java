package de.exxcellent.challenge;

import java.io.FileNotFoundException;
import java.util.List;

public class WeatherDatePicker {
    private List<WeatherDate> dates;
    public WeatherDatePicker(String filename) throws FileNotFoundException {
        this.dates = MinMaxDateReader.getWeatherDates(filename);
    }

    public String getDateWithSmallestTemperatureSpread() {
        int smallestSpread = dates.get(0).getMaxTemp() - dates.get(0).getMinTemp();
        String dayWithSmallestSpread = dates.get(0).getDay();
        for (WeatherDate date : dates) {
            int temperatureSpread = date.getMaxTemp() - date.getMinTemp();
            if (temperatureSpread < smallestSpread) {
                smallestSpread = temperatureSpread;
                dayWithSmallestSpread = date.getDay();
            }
        }
        return dayWithSmallestSpread;
    }
}
