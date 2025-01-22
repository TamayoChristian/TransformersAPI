package com.Transformers.Transformers_Backend.Models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="SubFaccion")
public class SubFaccion_model {
	//Atributos
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(unique = true, nullable = false)
	private long idSubFaccion;
	
	@Column(name="nombreSubFaccion")
	private String nombreSubFaccion;
	
	@Column(name = "lider")
	private String lider;
	
	@ManyToOne
	@JoinColumn(name="faccionPrincipal")
	private Facción_Model faccionPrincipal;

	public long getIdSubFaccion() {
		return idSubFaccion;
	}

	public void setIdSubFaccion(long idSubFaccion) {
		this.idSubFaccion = idSubFaccion;
	}

	public String getNombreSubFaccion() {
		return nombreSubFaccion;
	}

	public void setNombreSubFaccion(String nombreSubFaccion) {
		this.nombreSubFaccion = nombreSubFaccion;
	}

	public String getLider() {
		return lider;
	}

	public void setLider(String lider) {
		this.lider = lider;
	}

	public Facción_Model getFaccionPrincipal() {
		return faccionPrincipal;
	}

	public void setFaccionPrincipal(Facción_Model faccionPrincipal) {
		this.faccionPrincipal = faccionPrincipal;
	}
	
}
