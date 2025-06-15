package com.signalement.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.signalement.entities.Service;

public interface ServiceRepos extends JpaRepository<Service, Integer>{

}
