package de.exxcellent.challenge;

import de.comparison.Compare;

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

        Compare com_weather = new Compare("C:\\Users\\krueg\\challenge\\programming-challenge\\src\\main\\resources\\de\\exxcellent\\challenge\\weather.csv");
        Compare com_football = new Compare("C:\\Users\\krueg\\challenge\\programming-challenge\\src\\main\\resources\\de\\exxcellent\\challenge\\football.csv");

		try {
			String dayWithSmallestTempSpread = com_weather.minimumBetween("MnT", "MxT");
			System.out.printf("Day with smallest temperature spread : %s%n", dayWithSmallestTempSpread);
		} catch (Exception e) {
			e.printStackTrace();
		}
        
		try {
			String teamWithSmallestGoalSpread = com_football.minimumBetween("Goals", "Goals Allowed");
			System.out.printf("Team with smallest goal spread : %s%n", teamWithSmallestGoalSpread);
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
}
