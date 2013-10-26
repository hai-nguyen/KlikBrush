package com.klikbrush.logic;

public class BrushState {
	
	
	double frequencyX;
	double frequencyY;
	double frequencyZ;
	double strokelength;
	double circularity;
	int area;
	
	public BrushState(double frequencyX, double frequencyY, double frequencyZ,
			double strokelength, double circularity, int area) {
		super();
		this.frequencyX = frequencyX;
		this.frequencyY = frequencyY;
		this.frequencyZ = frequencyZ;
		this.strokelength = strokelength;
		this.circularity = circularity;
		this.area = area;
	}
	
	public double getFrequencyX() {
		return frequencyX;
	}
	public void setFrequencyX(double frequencyX) {
		this.frequencyX = frequencyX;
	}
	public double getFrequencyY() {
		return frequencyY;
	}
	public void setFrequencyY(double frequencyY) {
		this.frequencyY = frequencyY;
	}
	public double getFrequencyZ() {
		return frequencyZ;
	}
	public void setFrequencyZ(double frequencyZ) {
		this.frequencyZ = frequencyZ;
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
