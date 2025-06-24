package com.signalement.services;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.signalement.entities.Citoyen;
import com.signalement.repositories.CitoyenRepos;



@Service
public class CitoyenService {
	@Autowired
	CitoyenRepos citoyenRepos;
	public Citoyen saveOrCitoyen(Citoyen c) {
		if(!c.getNomCitoyen().isEmpty() && !c.getMailCitoyen().isEmpty() && !c.getPwdCitoyen().isEmpty()) {
			return citoyenRepos.save(c);
		}
		return null;
	}
		

	public List<Citoyen>getAll(){
		return citoyenRepos.findAll();
		
	}
	
	public Citoyen delete(Integer citoyenId) {
		Optional<Citoyen> c = citoyenRepos.findById(citoyenId);
		if(c.isPresent()) {
			citoyenRepos.deleteById(citoyenId);
			return c.get();
		}
		throw new NoSuchElementException("Aucun citoyen n'a été trouvé avec l'ID" + citoyenId);
	}
}
