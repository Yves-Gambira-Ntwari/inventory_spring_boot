package com.gambira.inventory.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gambira.inventory.models.Mdl_employee;

public interface Repo_employee extends JpaRepository<Mdl_employee, Long> {}
