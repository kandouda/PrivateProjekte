package com.khaled.tutorial.xml.dto;

public class Letter {

	private String street;
	private String name;

	public Letter(String name, String street) {
		this.name = name;
		this.street = street;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Dieser Brief ist von " + this.getName().trim()
				+ "; wohnhaft in " + this.getStreet().trim();
	}

}
