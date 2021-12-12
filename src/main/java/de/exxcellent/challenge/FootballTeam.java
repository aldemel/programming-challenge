package de.exxcellent.challenge;

import com.opencsv.bean.CsvBindByName;

public class FootballTeam implements MinMaxBean{


    @CsvBindByName(column = "Team")
    private String teamName;

    @CsvBindByName(column = "Goals")
    private int goals;

    @CsvBindByName(column = "Goals Allowed")
    private int goalsAllowed;

    @Override
    public int getSpread() {
        return Math.abs(goals - goalsAllowed);
    }

    @Override
    public String getLineKey() {
        return teamName;
    }

    @Override
    public String toString() {
        return "FootballTeam{" +
                "teamName='" + teamName + '\'' +
                ", goals=" + goals +
                ", goalsAllowed=" + goalsAllowed +
                '}';
    }
}
