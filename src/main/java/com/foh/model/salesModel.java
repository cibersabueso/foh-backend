package com.foh.model;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;

public class salesModel {
	
	private Integer clientID;
	private String client;
	private Date date;
	private BigDecimal total;
	private Integer saleID;
	public Integer getClientID() {
		return clientID;
	}
	public void setClientID(Integer clientID) {
		this.clientID = clientID;
	}
	public String getClient() {
		return client;
	}
	public void setClient(String client) {
		this.client = client;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public BigDecimal getTotal() {
		return total;
	}
	public void setTotal(BigDecimal total) {
		this.total = total;
	}
	public Integer getSaleID() {
		return saleID;
	}
	public void setSaleID(Integer saleID) {
		this.saleID = saleID;
	}	
	
}
