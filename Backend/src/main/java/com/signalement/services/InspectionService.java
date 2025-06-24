package com.signalement.services;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.signalement.entities.Inspection;
import com.signalement.repositories.InspectionRepos;

@Service

public class InspectionService {

	@Autowired
	InspectionRepos inspectionRepos;
	public Inspection saveOrUpdate(Inspection i) {
		if(!i.getDescriptionInspection().isEmpty() && i.getDate() != null && i.getHeureDebut() !=null && i.getHeureFin()!=null);
		return null;
	}
	public List<Inspection>getAll(){
		return inspectionRepos.findAll();
	}
	
	public Inspection delete(Integer inspectionId) {
		Optional<Inspection>  i =inspectionRepos.findById(inspectionId);
		if(i.isPresent()) {
			inspectionRepos.deleteById(inspectionId);
			return i.get();
		}
		throw new NoSuchElementException("Aucune inspection n'a été  trouvé avec l'id : "+ inspectionId);
	}
}
