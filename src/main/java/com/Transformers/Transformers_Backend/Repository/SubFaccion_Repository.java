package com.Transformers.Transformers_Backend.Repository;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.Transformers.Transformers_Backend.Models.SubFaccion_model;

@Repository
public interface SubFaccion_Repository extends CrudRepository<SubFaccion_model, Long>{
	public abstract ArrayList<SubFaccion_model> nombreSubFaccion(String nombreSubFaccion);
}
