package de.exxcellent.challenge;

import com.opencsv.bean.CsvBindByName;

public class WeatherDate extends MinMaxBean {
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
        return getDay();
    }

    @Override
    public String toString() {
        return "Date{" +
                "day='" + day + '\'' +
                ", maxTemp=" + maxTemp +
                ", minTemp=" + minTemp +
                '}';
    }

    public String getDay() {
        return day;
    }
}
