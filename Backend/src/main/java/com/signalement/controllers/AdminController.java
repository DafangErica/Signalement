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

import com.signalement.entities.Admin;
import com.signalement.services.AdminService;

@RestController
@CrossOrigin("*")
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	AdminService adminService;
	@PostMapping
	public ResponseEntity<?> save(@RequestBody Admin a) {
		Admin res = adminService.saveOrUpdate(a);
		if(res == null) {
			return new ResponseEntity<>("Echec d'enregistrement", HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<>(res, HttpStatus.OK);
	}
	@GetMapping
	public ResponseEntity<?> get(){
		return new ResponseEntity<>(adminService.getAll(), HttpStatus.OK);
	}
	
	@DeleteMapping(value = "/{adminId}")
	public ResponseEntity<String> delete(@PathVariable("adminId") Integer adminId){
		try {
				adminService.delete(adminId);
		      return new ResponseEntity<>("Administrateur supprimé avec succès", HttpStatus.NO_CONTENT);
		} catch (NoSuchElementException e) {
			        return new ResponseEntity<>("Aucun Administrateur trouvé avec l'ID : " + adminId, HttpStatus.NOT_FOUND);
   	} catch (Exception e) {
			        return new ResponseEntity<>("Échec de la suppression", HttpStatus.INTERNAL_SERVER_ERROR);
			    }
		}
}
