package com.signalement.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.signalement.entities.Citoyen;

public interface CitoyenRepos extends JpaRepository<Citoyen, Integer> {

}
