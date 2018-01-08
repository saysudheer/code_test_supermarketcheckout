package com.supermarket.collections;

import java.math.BigDecimal;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
/**
 * Provides the collection class to store
 * items added to card individually
 *
 */
@Document(collection = "CartItems")
public class CartItems {

	@Id
	private Integer id;

	private Integer itemId;
	private Integer quantity;
	private BigDecimal amount;

	public Integer getId() {
		return id;
	}

	public CartItems(Integer itemId, Integer quantity) {
		super();
		this.itemId = itemId;
		this.quantity = quantity;
		//this.amount = new BigDecimal(quantity * 10);
	}


	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getitemId() {
		return itemId;
	}

	public void setProduct_id(Integer itemId) {
		this.itemId = itemId;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

}