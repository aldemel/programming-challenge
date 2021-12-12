package de.exxcellent.challenge;

public class WeatherDate {
    String day;
    int maxTemp;
    int minTemp;

    public WeatherDate(String day, String maxTemp, String minTemp) {
        try{
            this.day = day;
            this.maxTemp = Integer.parseInt(maxTemp);
            this.minTemp = Integer.parseInt(minTemp);
        }
        catch (NumberFormatException ex){
            ex.printStackTrace();
        }
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
