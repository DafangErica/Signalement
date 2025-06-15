package com.signalement.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.signalement.entities.Inspecteur;

public interface InspecteurRepos extends JpaRepository<Inspecteur, Integer>{

}
