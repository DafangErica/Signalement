package com.signalement.services;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.signalement.entities.Quartier;

import com.signalement.repositories.QuartierRepos;

@Service
public class QuartierService {

  
	@Autowired
	QuartierRepos quartierRepos;

   
	public Quartier saveOrUpdate(Quartier q) {
		if (!q.getNomQuartier().isEmpty() ) {
			return quartierRepos.save(q);
		}
			return null;
	}
	public List<Quartier> getAll(){
		return quartierRepos.findAll();
		
	}
	
	
	public Quartier delete(Integer quartierId) {
		Optional<Quartier> q=quartierRepos.findById(quartierId)	;
		if(q.isPresent()) {
			quartierRepos.deleteById(quartierId);
			return q.get();
		}
		throw new NoSuchElementException("aucun quartier n'a l'ID : "+quartierId);
	}
	

}
