package com.gambira.inventory.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gambira.inventory.models.Mdl_department;

public interface Repo_department extends JpaRepository<Mdl_department, Long> {}
