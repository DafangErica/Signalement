package com.signalement.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.signalement.entities.Inspection;

public interface InspectionRepos extends JpaRepository<Inspection, Integer> {

}
