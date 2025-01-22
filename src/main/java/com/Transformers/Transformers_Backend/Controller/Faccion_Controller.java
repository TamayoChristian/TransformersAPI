package com.Transformers.Transformers_Backend.Controller;

import java.util.ArrayList;
import java.util.Optional;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Transformers.Transformers_Backend.Models.Facción_Model;
import com.Transformers.Transformers_Backend.Services.Faccion_Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;


@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/Faccion")
public class Faccion_Controller {
	@Autowired
	Faccion_Service faccion_Service;
	
	@GetMapping()
	public ArrayList<Facción_Model> recuperarFacciones(){
		return this.faccion_Service.recuperarFacciones();
	}
	
	@PostMapping()
	public Facción_Model guardarFaccion(@RequestBody Facción_Model facción_Model) {
		return this.faccion_Service.guardarFaccion(facción_Model);
	}
	
	@GetMapping(path = "/id/{id}")
	public Optional<Facción_Model> recuperarFaccionesPorId(@PathVariable("id") Long id) {
		return this.faccion_Service.recuperarFaccionPorId(id);
	}
	
	@GetMapping("/nombre/{nombreFaccion}")
	public ArrayList<Facción_Model> recuperarFaccionPorNombre(@PathVariable("nombreFaccion") String nombreFaccion){
		return this.faccion_Service.recuperarFaccionPorNombre(nombreFaccion);
	}
	
	@DeleteMapping(path = "/id/{id}")
	public String eliminarPorId(@PathVariable("id")Long id) {
		boolean ok = this.faccion_Service.eliminarFaccion(id);
		if(ok) {
			return "Facción eliminada";
		}
		else {
			return "No se pudo eliminar";
		}
	}
	
	@PutMapping("/id/{id}")
	public ResponseEntity<Facción_Model> ActualizarFaccion (@PathVariable("id")Long id, @RequestBody Facción_Model fac){
		try {
			Facción_Model actualizacion = faccion_Service.ActualizarFaccion(id, fac);
			return new ResponseEntity<>(actualizacion, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		}
	}
}
