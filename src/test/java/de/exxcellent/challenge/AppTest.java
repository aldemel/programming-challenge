package de.exxcellent.challenge;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
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
    void testReaderForWeatherFile() {
        String filename = "./src/main/resources/de/exxcellent/challenge/weather.csv";
        List<MinMaxBean> dates = MinMaxDateCsvReader.getMinMaxDates(WeatherDate.class, filename);
        assertEquals(30, dates.size());
        for (MinMaxBean date : dates) {
            System.out.println(date.toString());
        }
    }

    @Test
    void testWeatherDatePicker() {
        String filename = "./src/main/resources/de/exxcellent/challenge/weather.csv";
        List<MinMaxBean> dates = MinMaxDateCsvReader.getMinMaxDates(WeatherDate.class, filename);
        MinMaxDatePicker weatherDatePicker = new MinMaxDatePicker(dates);
        assertEquals("14", weatherDatePicker.getDateWithSmallestSpread());
    }

    @Test
    void testReaderForFootballFile() {
        String filename = "./src/main/resources/de/exxcellent/challenge/football.csv";
        List<MinMaxBean> dates = MinMaxDateCsvReader.getMinMaxDates(FootballTeam.class, filename);
        assertEquals(20, dates.size());
        for (MinMaxBean date : dates) {
            System.out.println(date.toString());
        }
    }

    @Test
    void testFootballDatePicker() {
        String filename = "./src/main/resources/de/exxcellent/challenge/football.csv";
        List<MinMaxBean> dates = MinMaxDateCsvReader.getMinMaxDates(FootballTeam.class, filename);
        MinMaxDatePicker footballDatePicker = new MinMaxDatePicker(dates);
        assertEquals("Aston_Villa", footballDatePicker.getDateWithSmallestSpread());
    }
}