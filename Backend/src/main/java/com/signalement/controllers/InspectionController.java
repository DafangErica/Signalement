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

import com.signalement.entities.Inspection;
import com.signalement.services.InspectionService;

@RestController
@CrossOrigin("*")
@RequestMapping("/inspection")

public class InspectionController {
	@Autowired
	InspectionService inspectionService;
	@PostMapping
	public ResponseEntity<?> save(@RequestBody Inspection i){
		Inspection res = inspectionService.saveOrUpdate(i);
		if(res == null) {
			return new ResponseEntity<>("Echec d' enregistrement", HttpStatus.INTERNAL_SERVER_ERROR);
			
		}
		return new ResponseEntity<>(res, HttpStatus.OK);
	}
	@GetMapping
	public  ResponseEntity<?> get() {
		return new ResponseEntity<>(inspectionService.getAll(), HttpStatus.OK);
	}
	
	@DeleteMapping(value = "/{inspectionId}")
	public ResponseEntity<String> delete(@PathVariable("inspectionId") Integer inspectionId){
		try {
					inspectionService.delete(inspectionId);
				      return new ResponseEntity<>("Inspection supprimé avec succès", HttpStatus.NO_CONTENT);
		} catch (NoSuchElementException e) {
					        return new ResponseEntity<>("Aucun Inspection trouvé avec l'ID : " + inspectionId, HttpStatus.NOT_FOUND);
		} catch (Exception e) {
					        return new ResponseEntity<>("Échec de la suppression", HttpStatus.INTERNAL_SERVER_ERROR);

			
		}
	}
	

}
