package de.exxcellent.challenge;

import com.opencsv.bean.CsvBindByName;

public class WeatherDate implements MinMaxBean {
    @CsvBindByName(column = "Day")
    private String day;

    @CsvBindByName(column = "MxT")
    private int maxTemp;

    @CsvBindByName(column = "MnT")
    private int minTemp;

    public WeatherDate() {

    }
    @Override
    public int getSpread() {
        return maxTemp - minTemp;
    }
    @Override
    public String getLineKey() {
        return day;
    }

    @Override
    public String toString() {
        return "Date{" +
                "day='" + day + '\'' +
                ", maxTemp=" + maxTemp +
                ", minTemp=" + minTemp +
                '}';
    }
}
