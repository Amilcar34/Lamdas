package model;

import java.util.Collections;
import java.util.List;

public class Camisa {

	final String color;
	final List<Talle> talles;
	
	public Camisa() {
		super();
		this.color = "";
		this.talles = Collections.emptyList();
	}

	public Camisa(String color, List<Talle> talles) {
		this.color = color;
		this.talles = talles;
	}

	public String getColor() {
		return color;
	}

	public List<Talle> getTalles() {
		return talles;
	}

	@Override
	public String toString() {
		return "Camisa [color=" + color + ", talles=" + talles + "]";
	}	
}
