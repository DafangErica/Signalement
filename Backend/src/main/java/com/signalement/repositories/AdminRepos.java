package com.signalement.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.signalement.entities.Admin;

public interface AdminRepos extends JpaRepository<Admin, Integer>{

}
