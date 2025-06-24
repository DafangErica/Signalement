package com.signalement.services;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.signalement.entities.Signalement;

import com.signalement.repositories.SignalementRepos;

@Service
public class SignalementService {

   
	@Autowired
	SignalementRepos signalementRepos;

 
	public Signalement saveOrUpdate(Signalement s) {
		if(!s.getLibSignalement().isEmpty() && !s.getDescriptionSignalement().isEmpty() && !s.getLocalisation().isEmpty()) {
			return signalementRepos.save(s);
		}
		return null;
	}
	public List<Signalement> getAll(){
		return signalementRepos.findAll();
	}
	public Signalement delete(Integer signalementId) {
		Optional<Signalement> s=signalementRepos.findById(signalementId);
		if(s.isPresent()) {
			signalementRepos.deleteById(signalementId);
			return s.get();
					
		}
		throw new NoSuchElementException("Aucun signalement n'a été touvé avec l'ID : "+signalementId);
		
	}

}
