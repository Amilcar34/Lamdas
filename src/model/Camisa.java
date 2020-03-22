package model;

public class Camisa {

	final String color;
	final Talle talle;
	
	public Camisa() {
		super();
		this.color = "";
		this.talle = null;
	}

	public Camisa(String color, Talle talle) {
		this.color = color;
		this.talle = talle;
	}

	public String getColor() {
		return color;
	}

	public Talle getTalle() {
		return talle;
	}

	@Override
	public String toString() {
		return "Camisa [color=" + color + ", talle=" + talle + "]";
	}
	
}
