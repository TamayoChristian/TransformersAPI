package com.Transformers.Transformers_Backend.Controller;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
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

import com.Transformers.Transformers_Backend.Models.SubFaccion_model;
import com.Transformers.Transformers_Backend.Services.SubFaccion_Service;
import org.springframework.web.bind.annotation.RequestParam;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/SubFacciones")
public class SubFacciones_Controller {
	@Autowired
	SubFaccion_Service subFaccion_Service;
	
	@GetMapping()
	public ArrayList<SubFaccion_model> obtenerSubFacciones(){
		return subFaccion_Service.recuperarFacciones();
	}
	
	@PostMapping()
	public SubFaccion_model guardarSubfacciones(@RequestBody SubFaccion_model subFac) {
		return this.subFaccion_Service.guardarSubFaccion(subFac);
	}
	
	@GetMapping(path = "/id/{id}")
	public Optional<SubFaccion_model> recuperarSubFaccionesPorId(@PathVariable("id")Long id) {
		return this.subFaccion_Service.obtenerSubFaccionPorId(id);
	}
	
	@GetMapping("/nombre/{nombreSubFaccion}")
	public ArrayList<SubFaccion_model> recuperarPorNombre(@PathVariable("nombreSubFaccion") String nombreSubFaccion){
		return this.subFaccion_Service.obtenerSubFaccionPorNombre(nombreSubFaccion);
	}
	
	@DeleteMapping(path = "/id/{id}")
	public String eliminarPorId (@PathVariable("id")Long id) {
		boolean ok = this.subFaccion_Service.eliminarSubFaccion(id);
		if(ok) {
			return "Subfacción eliminada con Exito";
		}
		else {
			return "No se pudo eliminar";
		}
	}
	
	@PutMapping("/id/{id}")
	public ResponseEntity<SubFaccion_model> ActualizarSubFaccion(@PathVariable("id")Long id, @RequestBody SubFaccion_model fac){
		try {
			SubFaccion_model actu = subFaccion_Service.ActualizarSubfaccion(id, fac);
			return new ResponseEntity<>(actu, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		}
	}
}
