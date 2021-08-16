package com.foh.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "detalle_venta")
public class saleDetailsEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "detalleventa_seq")
	@SequenceGenerator(sequenceName = "detalleventa_seq", allocationSize = 1, name = "detalleventa_seq")
	@Column(name = "detalle_venta_id")
	private Integer id;
	
	@Column(name = "venta_id")
	private Integer ventaID;
	
	@Column(name = "producto_id")
	private Integer productID;
	
	@Column(name = "cantidad")
	private Integer amount;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getVentaID() {
		return ventaID;
	}

	public void setVentaID(Integer ventaID) {
		this.ventaID = ventaID;
	}

	public Integer getProductID() {
		return productID;
	}

	public void setProductID(Integer productID) {
		this.productID = productID;
	}

	public Integer getAmount() {
		return amount;
	}

	public void setAmount(Integer amount) {
		this.amount = amount;
	}
	
}
