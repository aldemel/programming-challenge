package de.exxcellent.challenge;

import java.util.List;

public class WeatherDatePicker {
    List<WeatherDate> dates;
    public WeatherDatePicker(String filename) {
        this.dates = WeatherDateReader.getWeatherDates(filename);
    }

    public String getDateWithSmallestTemperatureSpread() {
        int smallestSpread = dates.get(0).maxTemp - dates.get(0).minTemp;
        String dayWithSmallestSpread = dates.get(0).day;
        for (WeatherDate date : dates) {
            int temperatureSpread = date.maxTemp - date.minTemp;
            if (temperatureSpread < smallestSpread) {
                smallestSpread = temperatureSpread;
                dayWithSmallestSpread = date.day;
            }
        }
        return dayWithSmallestSpread;
    }
}
