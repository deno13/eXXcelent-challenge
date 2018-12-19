package de.comparison;

import java.util.ArrayList;

/**
 * 
 * @author Denis Krueger <kruegede@gmx.de>
 *
 */

public class Compare {
	
	ArrayList<String []> data = new ArrayList<String[]>();
	String file;
	
	public Compare(String filename) {
		file = filename;
		Reader reader = new Reader(filename);
		data = reader.parseCSV();
	}
	
	// Gets the smallest difference of two columns
	public String minimumBetween(String att_1, String att_2) throws Exception {
		int att_1_index = getIndex(att_1);
		int att_2_index = getIndex(att_2);
		int min_row = 0;
		int min_diff = getDifference(1, att_1_index, att_2_index);
		for (int row = 2; row < data.size(); row++) {
			int current_diff = getDifference(row, att_1_index, att_2_index);
			if(current_diff < min_diff) {
				min_diff = current_diff;
				min_row = row;
			}
		}
		String [] min = (String[]) data.get(min_row);
		return min [0];
	}
	
	
	// Gets the difference between the values of two columns
	public int getDifference(int row_index, int att_1_index, int att_2_index) {
		String [] row = (String[]) data.get(row_index);
		int value_1 = Integer.parseInt(row [att_1_index]);
		int value_2 = Integer.parseInt(row [att_2_index]);
		if(value_1 >= value_2) {
			return (value_1 - value_2);
		} else {
			return (value_2 - value_1);
		}
	}
	
	// Finds the index of a column
	public int getIndex(String att) throws Exception {
		String [] header = (String[]) data.get(0);
		for (int i = 0; i <header.length; i++) {
			if(header [i].equals(att)) {
				return i;
			}
		}
		throw new Exception("Attribute not Found! Column does not exist.");
	}
}
