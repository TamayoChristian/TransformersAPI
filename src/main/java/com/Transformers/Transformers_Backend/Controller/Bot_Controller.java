package com.Transformers.Transformers_Backend.Controller;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Transformers.Transformers_Backend.Models.Bot_Model;
import com.Transformers.Transformers_Backend.Services.Bot_Service;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/Bots")
public class Bot_Controller {
	@Autowired
	Bot_Service bot_Service;
	
	@GetMapping()
	public ArrayList<Bot_Model> recuperarBots(){
		return bot_Service.recuperarBots();
	}
	
	@PostMapping()
	public Bot_Model obtenerBots(@RequestBody Bot_Model bot_Model){
		return this.bot_Service.guardarBot(bot_Model);
	}
	@GetMapping(path = "/id/{id}")
	public Optional<Bot_Model> recuperarBotsPorId(@PathVariable("id")Long id){
		return this.bot_Service.obtenerPorId(id);
	}
	
	@GetMapping("/nombre/{nombreTrans}")
	public ArrayList<Bot_Model> recuperarPorNombre(@PathVariable("nombreTrans") String nombreTrans) {
	    return this.bot_Service.obtenerPorNombre(nombreTrans);
	}
	
	@DeleteMapping(path = "/id/{id}")
	public String eliminarPorId(@PathVariable("id")Long id) {
		boolean ok = this.bot_Service.eliminarBot(id);
		if(ok) {
			return "Se ha eliminado al bot con el id " + id;
		}
		else {
			return "No se pudo eliminarl al bot con el id" + id;
		}
	}
	
	@PutMapping("/id/{id}")
	public ResponseEntity<Bot_Model> ActualizarBot(@PathVariable("id")Long id, @RequestBody Bot_Model bot){
		try {
			Bot_Model actualizar = bot_Service.ActualizarBot(id, bot);
			return new ResponseEntity<>(actualizar, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		}
	}
}
