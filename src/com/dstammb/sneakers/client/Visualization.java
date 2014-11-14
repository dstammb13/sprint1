package com.dstammb.sneakers.client;

import java.util.ArrayList;
import java.io.BufferedReader;

public class Visualization {

	private String country;
	private String region;
	private String year;
	private String goods;
	private String unit;
	
	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getGoods() {
		return goods;
	}

	public void setGoods(String goods) {
		this.goods = goods;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public Visualization(String country, String region, String year, String goods, String unit) {
		this.country = country;
		this.region = region;
		this.year = year;
		this.goods = goods; 
		this.unit = unit;
	}
	
	public Visualization(ArrayList<String> data) {
		this.country = data.get(0);
		this.region = data.get(1);
		this.year = data.get(2);
		this.goods = data.get(3);
		this.unit = data.get(4);
	}
	
	public Visualization() {
		this.country = "Switzerland";
		this.region = "Europe";
		this.year = "2010";
		this.goods = "Gold";
		this.unit = "Tons";
	}
	public Visualization getVisualization(Visualization v) {
		return v;
	}

}	