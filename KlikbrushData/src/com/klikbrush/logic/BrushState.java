package com.klikbrush.logic;

public class BrushState {
	
	
	double frequency;
	double strokelength;
	double circularity;
	int area;
	
	public BrushState(double frequency, double strokelength,
			double circularity, int area) {
		super();
		this.frequency = frequency;
		this.strokelength = strokelength;
		this.circularity = circularity;
		this.area = area;
	}

	public double getFrequency() {
		return frequency;
	}
	public void setFrequency(double frequency) {
		this.frequency = frequency;
	}
	public double getStrokelength() {
		return strokelength;
	}
	public void setStrokelength(double strokelength) {
		this.strokelength = strokelength;
	}
	public double getCircularity() {
		return circularity;
	}
	public void setCircularity(double circularity) {
		this.circularity = circularity;
	}
	public int getArea() {
		return area;
	}
	public void setArea(int area) {
		this.area = area;
	}
	
	
	

}
