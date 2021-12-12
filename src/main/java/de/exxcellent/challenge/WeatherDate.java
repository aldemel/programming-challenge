package de.exxcellent.challenge;

public class WeatherDate {
    String day;
    int maxTemp;
    int minTemp;

    public WeatherDate(String day, int maxTemp, int minTemp) {
        this.day = day;
        this.maxTemp = maxTemp;
        this. minTemp = minTemp;
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
