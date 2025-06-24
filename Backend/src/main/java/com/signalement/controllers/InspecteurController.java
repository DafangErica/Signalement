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

import com.signalement.entities.Inspecteur;
import com.signalement.services.InspecteurService;

@RestController
@CrossOrigin("*")
@RequestMapping("/inspecteur")
public class InspecteurController {
	@Autowired
	InspecteurService inspecteurService;
	@PostMapping
	public ResponseEntity<?> save(@RequestBody Inspecteur i) {
		Inspecteur res = inspecteurService.saveOrUpdate(i);
		if(res == null) {
			return new ResponseEntity<>("Echec d'ecregistrement", HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<>(res, HttpStatus.OK);
	}
	
	@GetMapping
	public ResponseEntity<?> get() {
		return new ResponseEntity<>(inspecteurService.getAll(), HttpStatus.OK);
	}
	
	@DeleteMapping(value = "/{inspecteurId}")
	public ResponseEntity<String> delete(@PathVariable("inspecteurId") Integer inspecteurId){
		try {
			inspecteurService.delete(inspecteurId);
		      return new ResponseEntity<>("Inspecteur supprimé avec succès", HttpStatus.NO_CONTENT);
		} catch (NoSuchElementException e) {
			        return new ResponseEntity<>("Aucun Inspecteur trouvé avec l'ID : " + inspecteurId, HttpStatus.NOT_FOUND);
     	} catch (Exception e) {
			        return new ResponseEntity<>("Échec de la suppression", HttpStatus.INTERNAL_SERVER_ERROR);
			    }
	}
}
