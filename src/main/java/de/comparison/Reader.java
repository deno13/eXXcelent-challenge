package de.comparison;

import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * 
 * @author Denis Krueger <kruegede@gmx.de>
 *
 */

public class Reader {
	
	String file;
	String separator = ",";
	ArrayList<String []> csv = new ArrayList<String[]>();
	
	public Reader(String filename) {
		file = filename;
	}
	
	// Reads the file and puts it an ArrayList
	public ArrayList<String[]> parseCSV() {
		BufferedReader reader = null;
		try {
			reader = new BufferedReader(new FileReader(file));
			int row_index = 0;
			String line = "";
			while((line = reader.readLine()) != null) {
				String [] row = line.split(separator);
				csv.add(row_index, row);
				row_index++;
			}
			reader.close();
		} catch (FileNotFoundException e) {
			System.out.println("File not Found!");
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return csv;
	}
}
