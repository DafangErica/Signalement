package com.signalement.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.signalement.entities.Domaine;

public interface DomaineRepos extends JpaRepository<Domaine, Integer> {

}
