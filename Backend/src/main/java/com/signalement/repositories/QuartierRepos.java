package com.signalement.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.signalement.entities.Quartier;

public interface QuartierRepos extends JpaRepository<Quartier, Integer> {

}
