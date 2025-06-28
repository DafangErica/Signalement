package com.signalement.controllers;

import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.signalement.entities.Quartier;
import com.signalement.services.QuartierService;

@RestController
@CrossOrigin("*")
@RequestMapping("/quartier")
public class QuartierController {
	@Autowired
	QuartierService quartierService;
	@PostMapping
	public ResponseEntity<?> save(@RequestBody Quartier q){
		Quartier res = quartierService.saveOrUpdate(q);
		if(res == null) {
			return new ResponseEntity<>("Echec de l' enregistrement", HttpStatus.INTERNAL_SERVER_ERROR);
		}
			return new ResponseEntity<>(res,HttpStatus.OK);
	}
	@GetMapping
	public ResponseEntity<?> get(){
		return new ResponseEntity<>(quartierService.getAll(), HttpStatus.OK);
	}
	
	@DeleteMapping(value= "/{quartierId}")
	public ResponseEntity<String> delete(@PathVariable("quartierId") Integer quartierId){
		try {
			quartierService.delete(quartierId);
			return new ResponseEntity<>("Quartier supprimé avec succès", HttpStatus.NO_CONTENT);
		}
		catch(NoSuchElementException e) {
			return new ResponseEntity<>("Aucun Quartier ne porte l' ID : "+ quartierId, HttpStatus.NOT_FOUND);
		}
		 catch (Exception e) {
		        return new ResponseEntity<>("Échec de la suppression", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
