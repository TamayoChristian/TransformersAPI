package com.Transformers.Transformers_Backend.Services;

import java.util.ArrayList;
import java.util.Optional;

import javax.management.RuntimeErrorException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Transformers.Transformers_Backend.Models.Facción_Model;
import com.Transformers.Transformers_Backend.Repository.Faccion_Repository;

@Service
public class Faccion_Service {
	@Autowired
	Faccion_Repository faccion_Repository;
	
	public ArrayList<Facción_Model> recuperarFacciones() {
		return (ArrayList<Facción_Model>) faccion_Repository.findAll();
	}
	
	public Facción_Model guardarFaccion(Facción_Model facción_Model) {
		return faccion_Repository.save(facción_Model);
	}
	
	public Optional<Facción_Model> recuperarFaccionPorId(Long id){
		return faccion_Repository.findById(id);
	}
	
	public ArrayList<Facción_Model> recuperarFaccionPorNombre(String faccion){
		return faccion_Repository.findByNombreFaccion(faccion);
	}
	
	public boolean eliminarFaccion(Long id) {
		try {
			faccion_Repository.deleteById(id);
			return true;
		} catch (Exception err) {
			return false;
		}
	}
	
	public Facción_Model ActualizarFaccion(Long id, Facción_Model actualizacion) {
		Optional<Facción_Model> registroAntiguo = recuperarFaccionPorId(id);
		if (registroAntiguo.isPresent()) {
			Facción_Model faccion = registroAntiguo.get();
			faccion.setLider(actualizacion.getLider());
			faccion.setNombreFaccion(actualizacion.getNombreFaccion());
			return faccion_Repository.save(faccion);
		} else {
			throw new RuntimeException("Faccion no encontrada");
		}
				
	}
}
