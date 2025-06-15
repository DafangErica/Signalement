package com.signalement.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.signalement.entities.Infrastructure;

public interface InfrastructureRepos extends JpaRepository<Infrastructure, Integer>{

}
