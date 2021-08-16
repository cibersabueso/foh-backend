package com.foh.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "venta")
public class saleEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "venta_seq")
	@SequenceGenerator(sequenceName = "venta_seq", allocationSize = 1, name = "venta_seq")
	@Column(name = "venta_id")
	private Integer id;
	
	@Column(name = "fecha")
	private Date date;
	
	@Column(name = "cliente_id")
	private Integer clientID;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Integer getClientID() {
		return clientID;
	}

	public void setClientID(Integer clientID) {
		this.clientID = clientID;
	}
	
}
