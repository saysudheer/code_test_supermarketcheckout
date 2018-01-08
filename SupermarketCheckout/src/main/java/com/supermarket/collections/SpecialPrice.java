package com.supermarket.collections;
/**
 * Provides the collection class necessary to create an  
 * special price of item when necessary 
 *
 */
public class SpecialPrice {

	private int id;
	private int quantity;
	private int  specialPrice;
	
	public SpecialPrice(){}
	
	

	public SpecialPrice(int id, int quantity,int specialPrice) {
		this.id = id;
		this.quantity=quantity;
		this.specialPrice = specialPrice;
	}



	public void setId(int id) {
		this.id = id;
	}



	public void setSpecialPrice(int specialPrice) {
		this.specialPrice = specialPrice;
	}



	public int getQuantity() {
		return quantity;
	}



	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}



	public int getId() {
		return id;
	}

	public int getSpecialPrice() {
		return specialPrice;
	}
	
}
