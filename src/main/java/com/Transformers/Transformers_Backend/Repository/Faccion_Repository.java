package com.Transformers.Transformers_Backend.Repository;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.Transformers.Transformers_Backend.Models.Facción_Model;
@Repository
public interface Faccion_Repository extends CrudRepository<Facción_Model, Long>{
	public abstract ArrayList<Facción_Model> findByNombreFaccion(String nombreFaccion);
}
