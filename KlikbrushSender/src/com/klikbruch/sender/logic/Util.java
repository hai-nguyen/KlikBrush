package com.klikbruch.sender.logic;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Util {
	
	public static final String delim = ";";
	
	public static void addDoublesToFiles(double[] realNumbersX, double[] imagNumbersX, double[] realNumbersY, double[] imagNumbersY, double[] realNumbersZ, double[] imagNumbersZ, File output, long[] timestamps) {

		FileWriter writer = null;

		try {
			writer = new FileWriter(output, true);

			for (int i = 0; i < realNumbersX.length; i++) {
				System.out.println("Util.addDoublesToFiles()");
				writer.append(Double.toString(realNumbersX[i]));
				writer.append(delim);
				writer.append(Double.toString(imagNumbersX[i]));
				writer.append(delim);
				writer.append(Double.toString(realNumbersY[i]));
				writer.append(delim);
				writer.append(Double.toString(imagNumbersY[i]));
				writer.append(delim);
				writer.append(Double.toString(realNumbersZ[i]));
				writer.append(delim);
				writer.append(Double.toString(imagNumbersZ[i]));
				writer.append(delim);
				writer.append(Double.toString(timestamps[i]));
				writer.append('\n');
			}
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
