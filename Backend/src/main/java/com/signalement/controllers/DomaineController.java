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

import com.signalement.entities.Domaine;
import com.signalement.services.DomaineService;

@RestController
@CrossOrigin("*")
@RequestMapping("/domaine")

public class DomaineController {
	@Autowired
	DomaineService domaineService;
	@PostMapping
	public ResponseEntity<?> save(@RequestBody Domaine d ){
		Domaine res = domaineService.saveOrUpdate(d);
		if(res == null) {
			return new ResponseEntity<>("Echec de l'enregistrement", HttpStatus.INTERNAL_SERVER_ERROR);
			
		}
		return new ResponseEntity<>(res, HttpStatus.OK);
	}
	 
	@GetMapping
	public ResponseEntity<?> get() {
		return new ResponseEntity<>(domaineService.getAll(), HttpStatus.OK);
	}
	
	@DeleteMapping(value="/{domaineId}")
	public ResponseEntity<String> delete(@PathVariable("domaineId") Integer domaineId ){
		
		try {
			domaineService.delete(domaineId);
		      return new ResponseEntity<>("Domaine supprimé avec succès", HttpStatus.NO_CONTENT);
		} catch (NoSuchElementException e) {
			        return new ResponseEntity<>("Aucun Domaine trouvé avec l'ID : " + domaineId, HttpStatus.NOT_FOUND);
		} catch (Exception e) {
			        return new ResponseEntity<>("Échec de la suppression", HttpStatus.INTERNAL_SERVER_ERROR);
			    }
			
		}
	}
	
			
	

