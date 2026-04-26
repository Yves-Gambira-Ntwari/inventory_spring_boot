package com.gambira.inventory.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gambira.inventory.models.Mdl_auditLog;

public interface Repo_auditLog extends JpaRepository<Mdl_auditLog, Long> {}
