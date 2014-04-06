
package com.example.khaled.model;

import java.util.ArrayList;
import java.util.List;

public class BeerExpert {

	public List<String> getBrands(String color) {

		List<String> brands = new ArrayList<String>();
		if (color.equals("amber")) {
			brands.add("Jack Amber");
			brands.add("Red Moose");
		}
		else {
			brands.add("Jail Pale Ail");
			brands.add("Gout stout");
		}
		return brands;
	}
}
