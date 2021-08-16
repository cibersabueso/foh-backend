package com.foh.model;

import java.util.Date;
import java.util.List;


public class saleModel {

	private Integer clientID;
	private Date date;
	private List<saleDetailsModel> products;
	
	public Integer getClientID() {
		return clientID;
	}
	public void setClientID(Integer clientID) {
		this.clientID = clientID;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public List<saleDetailsModel> getProducts() {
		return products;
	}
	public void setProducts(List<saleDetailsModel> products) {
		this.products = products;
	}
	
	
}
