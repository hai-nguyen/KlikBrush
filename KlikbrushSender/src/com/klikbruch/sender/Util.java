package com.klikbruch.sender;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Util {
	
	public static final String delim = ";";
	
	public static void addDoublesToFiles(double[] realNumbers, double[] imagNumbers, File output) {

		FileWriter writer = null;

		try {
			writer = new FileWriter(output, true);

			for (int i = 0; i < realNumbers.length; i++) {
				writer.append(Double.toString(realNumbers[i]));
				writer.append(delim);
				writer.append(Double.toString(imagNumbers[i]));
			}
			writer.append('\n');
		} catch (IOException e) {
			e.printStackTrace();
			// oh noes!
		} finally {
			if (writer != null) {
				try {
					writer.close();
				} catch (IOException ignore) {
				}
			}
		}

	}
	
	

}
