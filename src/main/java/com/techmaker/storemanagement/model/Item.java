package com.techmaker.storemanagement.model;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.search.mapper.pojo.mapping.definition.annotation.FullTextField;
import org.hibernate.search.mapper.pojo.mapping.definition.annotation.GenericField;
import org.hibernate.search.mapper.pojo.mapping.definition.annotation.Indexed;


@Entity
@Indexed
public class Item {
	@Id
	@GeneratedValue
	private long id;
	@FullTextField(analyzer = "item-name")
	private String name;
	private BigDecimal sellingPrice;
	private BigDecimal buyingPrice;
	private int quantity;
	@GenericField
	@Temporal(TemporalType.DATE)
	private Date addedDate;

	public Item() {
	}

	public Item(String name, BigDecimal sellingPrice, BigDecimal buyingPrice, int quantity, Date addedDate) {
		this.name = name;
		this.sellingPrice = sellingPrice;
		this.buyingPrice = buyingPrice;
		this.quantity = quantity;
		this.addedDate = addedDate;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public BigDecimal getSellingPrice() {
		return sellingPrice;
	}

	public void setSellingPrice(BigDecimal sellingPrice) {
		this.sellingPrice = sellingPrice;
	}

	public BigDecimal getBuyingPrice() {
		return buyingPrice;
	}

	public void setBuyingPrice(BigDecimal buyingPrice) {
		this.buyingPrice = buyingPrice;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Date getAddedDate() {
		return addedDate;
	}

	public void setAddedDate(Date addedDate) {
		this.addedDate = addedDate;
	}

	@Override
	public String toString() {
		return "Item [id=" + id + ", name=" + name + ", sellingPrice=" + sellingPrice + ", buyingPrice=" + buyingPrice
				+ ", quantity=" + quantity + ", addedDate=" + addedDate + "]";
	}
	
	
}
