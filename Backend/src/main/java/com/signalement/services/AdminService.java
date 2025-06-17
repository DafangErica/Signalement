package com.signalement.services;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.signalement.entities.Admin;
import com.signalement.repositories.AdminRepos;

@Service
public class AdminService {

	@Autowired
	AdminRepos adminRepos;
	public Admin saveOrUpdate(Admin a) {
		if(!a.getMailAdmin().isEmpty() && !a.getNomAdmin().isEmpty() && !a.getPwdAdmin().isEmpty()) {
			return adminRepos.save(a);
		}
		return null;
	}
	
	public List<Admin> getAll() {
		return adminRepos.findAll();
	}
	
	public Admin delete(Integer adminId) {
		Optional<Admin> a = adminRepos.findById(adminId);
		if(a.isPresent()) {
			adminRepos.deleteById(adminId);
			return a.get();
		}
		throw new NoSuchElementException("Aucun administrateur n'a été trouvé avec l'ID : " + adminId);
	}
}
