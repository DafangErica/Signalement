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

import com.signalement.entities.Signalement;
import com.signalement.services.SignalementService;

@RestController
@CrossOrigin("*")
@RequestMapping("/signalement")
public class SignalementController {
	@Autowired
	SignalementService signalementService;
	@PostMapping
	public ResponseEntity<?> save(@RequestBody Signalement s){
	Signalement res =signalementService.saveOrUpdate(s);
	if (res== null) {
		return new ResponseEntity<>("Echec de l'enregistrement", HttpStatus.INTERNAL_SERVER_ERROR);
		
	}
	return new ResponseEntity<>(res, HttpStatus.OK);
	}
	
	@GetMapping
	public ResponseEntity<?> get() {
		return new ResponseEntity<>(signalementService.getAll(), HttpStatus.OK);
		
	}
	
	@DeleteMapping(value = "/{signalementId}")
	public ResponseEntity<String> delete(@PathVariable("signalementId") Integer signalementId){
		try {
			signalementService.delete(signalementId);
		      return new ResponseEntity<>("Signalement supprimé avec succès", HttpStatus.NO_CONTENT);
		} catch (NoSuchElementException e) {
			        return new ResponseEntity<>("Aucun Signalement trouvé avec l'ID : " + signalementId, HttpStatus.NOT_FOUND);
     	} catch (Exception e) {
			        return new ResponseEntity<>("Échec de la suppression", HttpStatus.INTERNAL_SERVER_ERROR);
			    }
	}
	}



