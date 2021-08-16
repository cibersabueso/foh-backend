package com.foh.model;

import java.math.BigDecimal;

public class responseDetailsProductModel {
	private Integer saleID;
	private Integer amount;
	private BigDecimal total;
	private BigDecimal price;
	private String name;
	public Integer getSaleID() {
		return saleID;
	}
	public void setSaleID(Integer saleID) {
		this.saleID = saleID;
	}
	public Integer getAmount() {
		return amount;
	}
	public void setAmount(Integer amount) {
		this.amount = amount;
	}
	public BigDecimal getTotal() {
		return total;
	}
	public void setTotal(BigDecimal total) {
		this.total = total;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}
