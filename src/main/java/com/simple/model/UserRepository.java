package com.simple.model;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserModel, Integer>{
	
	Optional<UserModel> findByLoginAndPassword(String login,String password);
	Optional<UserModel> findFirstByLogin(String login);
}
