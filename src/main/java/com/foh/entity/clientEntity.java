package com.foh.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "cliente")
public class clientEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "client_seq")
	@SequenceGenerator(sequenceName = "client_seq", allocationSize = 1, name = "client_seq")
	@Column(name = "cliente_id")
	private Integer id;
	
	@Column(name = "nombres")
	private String name;
	
	@Column(name = "apellidos")
	private String lastName;
	
	@Column(name = "dni")
	private String dni;
	
	@Column(name = "telefono")
	private String cellphone;
	
	@Column(name = "email")
	private String email;

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

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getCellphone() {
		return cellphone;
	}

	public void setCellphone(String cellphone) {
		this.cellphone = cellphone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
}
