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

import com.signalement.entities.Citoyen;
import com.signalement.services.CitoyenService;

@RestController
@CrossOrigin("*")
@RequestMapping("/citoyen")
public class CitoyenController {
	@Autowired
	CitoyenService citoyenService;
	@PostMapping
	public ResponseEntity<?> save(@RequestBody Citoyen c){
		Citoyen res = citoyenService.saveOrUpdate(c);
		if(res==null) {
			return new ResponseEntity<>("Echec de l'enregistrement ", HttpStatus.INTERNAL_SERVER_ERROR);	
		}
		return new ResponseEntity<>(res,HttpStatus.OK);
	}
	@GetMapping
	public ResponseEntity<?> get(){
		return new ResponseEntity<>(citoyenService.getAll(), HttpStatus.OK);
	
	
	}
	
	@DeleteMapping(value="/{citoyenId}")
	public ResponseEntity<String> deletre(@PathVariable("citoyenId")Integer citoyenId){
		try {
			citoyenService.delete(citoyenId);
			return new ResponseEntity<>("citoyen suprimé avec succés", HttpStatus.NO_CONTENT);
			
		}
		catch (NoSuchElementException e) {
			return  new ResponseEntity<>("Aucun Inspecteur trouvé qvec l'ID : " + citoyenId, HttpStatus.NOT_FOUND);
			
		}
		catch (Exception e ) {
			return new ResponseEntity<>("echec de la suppression", HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
}
