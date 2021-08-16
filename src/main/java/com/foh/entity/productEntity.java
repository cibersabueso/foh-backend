package com.foh.entity;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "producto")
public class productEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "producto_seq")
	@SequenceGenerator(sequenceName = "producto_seq", allocationSize = 1, name = "producto_seq")
	@Column(name = "producto_id")
	private Integer id;
	
	@Column(name = "nombre")
	private String name;

	@Column(name = "precio")
	private BigDecimal price;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}
		
}
