package com.Transformers.Transformers_Backend.Services;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Transformers.Transformers_Backend.Models.SubFaccion_model;
import com.Transformers.Transformers_Backend.Repository.SubFaccion_Repository;

@Service
public class SubFaccion_Service {
	@Autowired
	SubFaccion_Repository subfaccion_Repository;
	
	public ArrayList<SubFaccion_model> recuperarFacciones(){
		return (ArrayList<SubFaccion_model>)subfaccion_Repository.findAll();
	}
	
	public SubFaccion_model guardarSubFaccion(SubFaccion_model SubFaccion) {
		return subfaccion_Repository.save(SubFaccion); 
	}
	
	public Optional<SubFaccion_model> obtenerSubFaccionPorId(Long id){
		return subfaccion_Repository.findById(id);
	}
	
	public ArrayList<SubFaccion_model> obtenerSubFaccionPorNombre(String nombreSub){
		return subfaccion_Repository.nombreSubFaccion(nombreSub);
	}
	
	public boolean eliminarSubFaccion(Long id) {
		try {
			subfaccion_Repository.deleteById(id);
			return false;
		} catch (Exception e) {
			return false;
		}
	}
	
	public SubFaccion_model ActualizarSubfaccion(Long id, SubFaccion_model actu) {
		Optional<SubFaccion_model> registroAnterior = obtenerSubFaccionPorId(id);
		if(registroAnterior.isPresent()) {
			SubFaccion_model subFac = registroAnterior.get();
			subFac.setLider(actu.getLider());
			subFac.setNombreSubFaccion(actu.getNombreSubFaccion());
			subFac.setFaccionPrincipal(actu.getFaccionPrincipal());
			return subfaccion_Repository.save(subFac);
		}else {
			throw new RuntimeException("Subfacion no encontrada");
		}
	}
}