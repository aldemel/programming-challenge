package de.exxcellent.challenge;

import java.io.FileNotFoundException;
import java.util.List;

/**
 * The entry class for your solution. This class is only aimed as starting point and not intended as baseline for your software
 * design. Read: create your own classes and packages as appropriate.
 *
 * @author Benjamin Schmid <benjamin.schmid@exxcellent.de>
 */
public final class App {

    /**
     * This is the main entry method of your program.
     * @param args The CLI arguments passed
     */
    public static void main(String... args) {

        // Your preparation code …
        String resourcePath = "./src/main/resources/de/exxcellent/challenge/";
        String weatherFilename = "";
        String footballFileName = "";
        for (int i = 0; i < args.length; ++i) {
            if (args[i].equals("--weather")) {
                if (i + 1 < args.length) {
                    weatherFilename = args[i+1];
                }
            }
            if (args[i].equals("--football")) {
                if (i + 1 < args.length) {
                    footballFileName = args[i+1];
                }
            }
        }

        if (weatherFilename.isEmpty() && footballFileName.isEmpty()) {
            System.out.println("There was no input provided.");
        }

        if (!weatherFilename.isEmpty()) {
            var weatherDates = MinMaxDateCsvReader.getMinMaxDates(WeatherDate.class, resourcePath + weatherFilename);
            MinMaxDatePicker weatherDatePicker = new MinMaxDatePicker(weatherDates);
            String dayWithSmallestTempSpread = weatherDatePicker.getDateWithSmallestSpread();     // Your day analysis function call …
            System.out.printf("Day with smallest temperature spread : %s%n", dayWithSmallestTempSpread);
        }

        if (!footballFileName.isEmpty()) {
            var footbalTeamDates = MinMaxDateCsvReader.getMinMaxDates(FootballTeam.class, resourcePath + footballFileName);
            MinMaxDatePicker footballTeamPicker = new MinMaxDatePicker(footbalTeamDates);
            String teamWithSmallestGoalSpread = footballTeamPicker.getDateWithSmallestSpread(); // Your goal analysis function call …
            System.out.printf("Team with smallest goal spread       : %s%n", teamWithSmallestGoalSpread);
        }

    }
}
