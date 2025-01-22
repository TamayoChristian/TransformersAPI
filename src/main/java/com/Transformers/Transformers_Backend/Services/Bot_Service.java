package com.Transformers.Transformers_Backend.Services;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Transformers.Transformers_Backend.Models.Bot_Model;
import com.Transformers.Transformers_Backend.Repository.Bot_Repository;

@Service
public class Bot_Service {
	@Autowired
	Bot_Repository bot_Repository;
	
	public ArrayList<Bot_Model> recuperarBots() {
		return (ArrayList<Bot_Model>) bot_Repository.findAll();
	}
	
	public Bot_Model guardarBot(Bot_Model bot_model) {
		return bot_Repository.save(bot_model);
	}
	
	public Optional<Bot_Model> obtenerPorId(Long id){
		return bot_Repository.findById(id);
	}
	
	public ArrayList<Bot_Model> obtenerPorNombre(String nombreTrans){
		return bot_Repository.findByNombreTrans(nombreTrans);
	}
	
	public boolean eliminarBot(Long id) {
		try {
			bot_Repository.deleteById(id);
			return true;
		} catch (Exception err) {
			return false;
		}
	}
	
	public Bot_Model ActualizarBot(Long id, Bot_Model actualizacion) {
		Optional<Bot_Model> registroAnterior = obtenerPorId(id);
		if(registroAnterior.isPresent()) {
			Bot_Model bot = registroAnterior.get();
			bot.setNombreTrans(actualizacion.getNombreTrans());
			bot.setAltura(actualizacion.getAltura());
			bot.setPeso(actualizacion.getPeso());
			bot.setRango(actualizacion.getRango());
			bot.setModoAlterno(actualizacion.getModoAlterno());
			bot.setPersonalidad(actualizacion.getPersonalidad());
			bot.setGenero(actualizacion.getGenero());
			bot.setUrlImagen(actualizacion.getUrlImagen());
			bot.setSubFaccion(actualizacion.getSubFaccion());
			return bot_Repository.save(bot);
		} else {
			throw new RuntimeException("Bot no ecnontrado");
		}
	}
}
