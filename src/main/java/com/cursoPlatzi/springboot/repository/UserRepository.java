package com.cursoPlatzi.springboot.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cursoPlatzi.springboot.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{
	
	//IMPLEMENTANDO LA UTILIDAD DE JPQL
	@Query("Select u from User u WHERE u.email=:email")
	Optional<User> findByUserEmail(@Param("email") String email);
	
	@Query("Select u from User u WHERE u.name like ?1%")
	List<User> findAndSort(@Param("name") String name, Sort sort);
	
	//Quyery Methods
	
}
 