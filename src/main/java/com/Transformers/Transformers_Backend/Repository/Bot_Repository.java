package com.Transformers.Transformers_Backend.Repository;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.Transformers.Transformers_Backend.Models.Bot_Model;

@Repository
public interface Bot_Repository extends CrudRepository<Bot_Model, Long> {
	public abstract ArrayList<Bot_Model> findByNombreTrans(String nombreTrans);
}
