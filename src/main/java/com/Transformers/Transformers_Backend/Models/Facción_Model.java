package com.Transformers.Transformers_Backend.Models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Faccion")
public class Facción_Model {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(unique = true, nullable = false)
	private Long idFaccion;
	
	@Column(name="nombreFaccion")
	private String nombreFaccion;
	
	@Column(name="lider")
	private String lider;
	
	
	//Getters and setters
	public Long getIdFaccion() {
		return idFaccion;
	}

	public void setIdFaccion(Long idFaccion) {
		this.idFaccion = idFaccion;
	}

	public String getNombreFaccion() {
		return nombreFaccion;
	}

	public void setNombreFaccion(String nombreFaccion) {
		this.nombreFaccion = nombreFaccion;
	}

	public String getLider() {
		return lider;
	}

	public void setLider(String lider) {
		this.lider = lider;
	}
	
}
