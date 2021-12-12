package de.exxcellent.challenge;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Example JUnit 5 test case.
 * @author Benjamin Schmid <benjamin.schmid@exxcellent.de>
 */
class AppTest {

    private String successLabel = "not successful";

    @BeforeEach
    void setUp() {
        successLabel = "successful";
    }

    @Test
    void aPointlessTest() {
        assertEquals("successful", successLabel, "My expectations were not met");
    }

    @Test
    void runFootball() {
        App.main("--football", "football.csv");
    }

    @Test
    void runWeather() {
        App.main("--weather", "weather.csv");
    }

    @Test
    void testReader() throws FileNotFoundException {
        String filename = "./src/main/resources/de/exxcellent/challenge/weather.csv";
        List<MinMaxBean> dates = MinMaxDateReader.getMinMaxDates(WeatherDate.class, filename);
        for (MinMaxBean date : dates) {
            System.out.println(date.toString());
        }
    }

    @Test
    void testWeatherDatePicker() throws FileNotFoundException {
        String filename = "./src/main/resources/de/exxcellent/challenge/weather.csv";
        MinMaxDatePicker weatherDatePicker = new MinMaxDatePicker(WeatherDate.class, filename);
        assertEquals("14", weatherDatePicker.getDateWithSmallestSpread());
    }

}