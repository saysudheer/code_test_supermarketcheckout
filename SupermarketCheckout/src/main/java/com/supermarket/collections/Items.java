package com.supermarket.collections;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
/**
 * Provides the collection class necessary to create an  
 * entity to save Items 
 *
 */
@Document(collection = "Items")
public class Items {
	@Id
    private Integer id;
    private String item;
    private int unitPrice;
    private SpecialPrice specialPrice;

    public Items(Integer id,String item, int unitprice, SpecialPrice specialprice ) {
        this.id = id;
        this.item = item;
        this.unitPrice = unitprice;
        this.specialPrice = specialprice;
    }

	public Items(Integer id, String item, int unitprice) {
		this.id = id;
        this.item = item;
        this.unitPrice = unitprice;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Items() {
		super();
		// TODO Auto-generated constructor stub
	}

	public void setItem(String item) {
		this.item = item;
	}

	public void setUnitPrice(int unitPrice) {
		this.unitPrice = unitPrice;
	}

	public void setSpecialPrice(SpecialPrice specialPrice) {
		this.specialPrice = specialPrice;
	}

	public long getId() {
		return id;
	}

	public String getItem() {
		return item;
	}

	public int getUnitPrice() {
		return unitPrice;
	}

	public SpecialPrice getSpecialPrice() {
		return specialPrice;
	}

   

   
}