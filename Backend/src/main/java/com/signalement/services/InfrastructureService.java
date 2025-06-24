package com.signalement.services;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.signalement.entities.Infrastructure;
import com.signalement.repositories.InfrastructureRepos;

@Service

public class InfrastructureService {

	
	@Autowired
	InfrastructureRepos infrastructureRepos;
	public Infrastructure  saveOrUpdaten (Infrastructure i) {
		if(!i.getNomInfrastructure().isEmpty() && !i.getDescriptionInfrastructure().isEmpty() && !i.getEtat().isEmpty() && !i.getType().isEmpty() ) {
			return infrastructureRepos.save(i);
		}
		return null;
		
	}
	public List<Infrastructure> getAll(){
		return infrastructureRepos.findAll();
		
	}
	
	public Infrastructure delete (Integer infrastructureId) {
		Optional<Infrastructure> i = infrastructureRepos.findById(infrastructureId);
		if(i.isPresent()) {
			infrastructureRepos.deleteById(infrastructureId);
			return i.get();
		}
		throw new  NoSuchElementException("Aucune infrastructure n'a été trouvé avec l'ID : "+ infrastructureId);
	}
	
}
