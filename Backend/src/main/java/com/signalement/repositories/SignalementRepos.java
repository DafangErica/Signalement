package com.signalement.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.signalement.entities.Signalement;

public interface SignalementRepos extends JpaRepository<Signalement, Integer> {

}
