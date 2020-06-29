package com.ezshop.model;

public class Ticket {
	
	// fields
	private int round;
	private String yourTeam;
	private float price;
	private int quantity;

	// Writing accessors and mutators
	// getters
	public int getRound() {
		return round;
	}

	public String getYourTeam() {
		return yourTeam;
	}

	public float getPrice() {
		return price;
	}

	public int getQuantity() {
		return quantity;
	}
	
	// setters
	public void setRound(int round) {
		this.round = round;
	}

	public void setYourTeam(String yourTeam) {
		this.yourTeam = yourTeam;
	}
	
	public void setPrice(float price) {
		this.price = price;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	@Override
	public String toString() {
		return "Tickets [round=" + round + ", yourTeam=" + yourTeam + ", price=" + price + ", quantity="
				+ quantity + "]";
	}	
	
}
