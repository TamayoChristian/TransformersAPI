package com.Transformers.Transformers_Backend.Models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="Bots")
public class Bot_Model {
	
	//Atributos
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(unique = true, nullable = false)
	private Long idTransformer;
	
	@Column(name="nombreTrans")
	private String nombreTrans;
	
	@Column(name = "altura")
	private float altura;
	
	@Column(name = "peso")
	private float peso;
	
	@Column(name = "rango")
	private String rango;
	
	@Column(name = "modoAlterno")
	private String modoAlterno;
	
	@Column(name = "personalidad")
	private String personalidad;
	
	@Column(name = "genero")
	private String genero;
	
	@Column(name = "urlImagen")
	private String urlImagen;
	
	@ManyToOne
	@JoinColumn(name ="faccion")
	private Facción_Model faccion;
	
	@ManyToOne
	@JoinColumn(name="Subfaccion")
	private SubFaccion_model subFaccion;

	//Getters and setters

	
	public Long getIdTransformer() {
		return idTransformer;
	}

	public void setIdTransformer(Long idTransformer) {
		this.idTransformer = idTransformer;
	}

	public String getNombreTrans() {
		return nombreTrans;
	}

	public void setNombreTrans(String nombreTrans) {
		this.nombreTrans = nombreTrans;
	}

	public float getAltura() {
		return altura;
	}

	public void setAltura(float altura) {
		this.altura = altura;
	}

	public float getPeso() {
		return peso;
	}

	public void setPeso(float peso) {
		this.peso = peso;
	}

	public String getRango() {
		return rango;
	}

	public void setRango(String rango) {
		this.rango = rango;
	}

	public String getModoAlterno() {
		return modoAlterno;
	}

	public void setModoAlterno(String modoAlterno) {
		this.modoAlterno = modoAlterno;
	}

	public String getPersonalidad() {
		return personalidad;
	}

	public void setPersonalidad(String personalidad) {
		this.personalidad = personalidad;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public String getUrlImagen() {
		return urlImagen;
	}

	public void setUrlImagen(String urlImagen) {
		this.urlImagen = urlImagen;
	}
	
	public Facción_Model getFaccion() {
		return faccion;
	}

	public void setFaccion(Facción_Model faccion) {
		this.faccion = faccion;
	}

	public SubFaccion_model getSubFaccion() {
		return subFaccion;
	}

	public void setSubFaccion(SubFaccion_model subFaccion) {
		this.subFaccion = subFaccion;
	}
	
}
