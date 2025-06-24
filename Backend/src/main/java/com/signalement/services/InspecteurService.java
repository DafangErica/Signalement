package com.signalement.services;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.signalement.entities.Inspecteur;
import com.signalement.repositories.InspecteurRepos;

@Service
public class InspecteurService {
 
	@Autowired
	InspecteurRepos inspecteurRepos;
	public Inspecteur saveOrUpdate(Inspecteur i) {
		if(!i.getMailInspecteur().isEmpty() && !i.getNomInspecteur().isEmpty() && !i.getTelInspecteur().isEmpty() && !i.getPwdInspecteur().isEmpty() ) {
			return inspecteurRepos.save(i);
		}
		return null;
	}
	
	public List<Inspecteur>getAll(){
		return inspecteurRepos.findAll();
	}
	
	public Inspecteur delete (Integer inspecteurId ) {
		Optional<Inspecteur> i = inspecteurRepos.findById(inspecteurId);
		if(i.isPresent()) {
			inspecteurRepos.deleteById(inspecteurId);
			return i.get();
			
		}
		throw new NoSuchElementException("Aucun Inspecteur ne porte l' ID" + inspecteurId);
	}
}
