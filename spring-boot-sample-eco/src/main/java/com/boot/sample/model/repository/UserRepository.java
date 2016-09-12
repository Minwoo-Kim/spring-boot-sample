package com.boot.sample.model.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.boot.sample.model.entity.User;

/**
 * User Repository
 * 
 * @author Minu.Kim
 */
public interface UserRepository extends JpaRepository<User, String> {
	
	/**
	 * find user by ID
	 *  
	 * @param email
	 * @return
	 */
	public User readUserById(String id);

	/**
	 * find user by name
	 * 
	 * @param name
	 * @return
	 */
	public List<User> findByNameLike(String name);
}
