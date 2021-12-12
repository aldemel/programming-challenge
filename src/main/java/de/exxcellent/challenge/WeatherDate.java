package de.exxcellent.challenge;

import com.opencsv.bean.CsvBindByName;

public class WeatherDate {
    @CsvBindByName(column = "Day")
    private String day;

    @CsvBindByName(column = "MxT")
    private int maxTemp;

    @CsvBindByName(column = "MnT")
    private int minTemp;

    public WeatherDate() {

    }

    @Override
    public String toString() {
        return "Date{" +
                "day='" + day + '\'' +
                ", maxTemp=" + maxTemp +
                ", minTemp=" + minTemp +
                '}';
    }

    public int getMaxTemp() {
        return maxTemp;
    }

    public int getMinTemp() {
        return minTemp;
    }

    public String getDay() {
        return day;
    }
}
