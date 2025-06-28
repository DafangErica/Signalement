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

import com.signalement.entities.Infrastructure;
import com.signalement.services.InfrastructureService;

@RestController
@CrossOrigin("*")
@RequestMapping("/Infrastructure")

public class InfrastructureController {
	@Autowired
	InfrastructureService infrastructureService;
	@PostMapping
	public ResponseEntity<?> save(@RequestBody Infrastructure i){
		
		Infrastructure res = infrastructureService.saveOrUpdaten(i);
		if(res== null) {
			return new ResponseEntity<>("Echec de l'enregistrement", HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<>(res, HttpStatus.OK);
	}
	
	@GetMapping
	public ResponseEntity<?>get(){
		return new ResponseEntity<> (infrastructureService.getAll(), HttpStatus.OK);

	}
	
	@DeleteMapping(value = "/{infrastructureId}")
	public ResponseEntity<String> delete(@PathVariable ("infrastructureId") Integer infrastructureId){
		try {
			infrastructureService.delete(infrastructureId);
			return new ResponseEntity<>("Infrastructure supprimé avec succès", HttpStatus.NO_CONTENT);
		}
		catch(NoSuchElementException e ) {
			return new ResponseEntity<>("aucune Infrastructure ne porte cette ID: " + infrastructureId, HttpStatus.NOT_FOUND);
		}
		catch(Exception e){
			return new ResponseEntity<>("Echec de la Suppresion ", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
