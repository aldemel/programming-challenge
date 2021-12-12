package de.exxcellent.challenge;

import java.io.FileNotFoundException;

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
            if (args[i] == "--weather") {
                if (i + 1 < args.length) {
                    weatherFilename = args[i+1];
                }
            }
            if (args[i] == "--football") {
                if (i + 1 < args.length) {
                    footballFileName = args[i+1];
                }
            }
        }

        if (weatherFilename.isEmpty() && footballFileName.isEmpty()) {
            System.out.println("No files set.");
        }

        try {
            if (!weatherFilename.isEmpty()) {
                MinMaxDatePicker weatherDatePicker = new MinMaxDatePicker(WeatherDate.class, resourcePath + weatherFilename);
                String dayWithSmallestTempSpread = weatherDatePicker.getDateWithSmallestSpread();     // Your day analysis function call …
                System.out.printf("Day with smallest temperature spread : %s%n", dayWithSmallestTempSpread);
            }

            if (!footballFileName.isEmpty()) {
                String teamWithSmallestGoalSpread = "A good team"; // Your goal analysis function call …
                System.out.printf("Team with smallest goal spread       : %s%n", teamWithSmallestGoalSpread);
            }
        }
        catch (FileNotFoundException ex)
        {
            ex.printStackTrace();
        }

    }
}
