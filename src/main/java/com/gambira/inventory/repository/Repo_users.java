package com.gambira.inventory.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.gambira.inventory.models.Mdl_users;

public interface Repo_users extends JpaRepository<Mdl_users, Long> {
	
	@Query(value = "select distinct *from users where username = ?1 and password = ?2", nativeQuery=true)
	Mdl_users getUser(String username, String password);
	
}
