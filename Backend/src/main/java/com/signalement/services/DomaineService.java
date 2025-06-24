package com.signalement.services;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.signalement.entities.Domaine;
import com.signalement.repositories.DomaineRepos;

@Service
public class DomaineService {
	
	@Autowired
	DomaineRepos domaineRepos;
	
	 public Domaine saveOrUpdate(Domaine d) {
		 if(!d.getNomDomaine().isEmpty() && !d.getMailDomaine().isEmpty()) {
			 return domaineRepos.save(d);
		 }
		 
		 return null;
	 }
	
	 public List<Domaine> getAll(){
		 return  domaineRepos.findAll();
	 }
	 
	 public Domaine delete(Integer domaineId) {
		 Optional<Domaine> d=domaineRepos.findById(domaineId);
		 if(d.isPresent()) {
			 domaineRepos.deleteById(domaineId);
			 return d.get();
			 
		 }
		 throw new NoSuchElementException("aucun domaine ne porte cet ID : " +domaineId );
	 }

}
