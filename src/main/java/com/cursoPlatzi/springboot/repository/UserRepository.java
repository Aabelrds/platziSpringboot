package com.cursoPlatzi.springboot.repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cursoPlatzi.springboot.dto.UserDto;
import com.cursoPlatzi.springboot.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{
	
	//IMPLEMENTANDO LA UTILIDAD DE JPQL
	@Query("Select u from User u WHERE u.email=:email")
	Optional<User> findByUserEmail(@Param("email") String email);
	
	@Query("Select u from User u WHERE u.name like ?1%")
	List<User> findAndSort(@Param("name") String name, Sort sort);
	
	//Quyery Methods implement
	
	List<User> findByName(String name);
	
	Optional<User> findByEmailAndName(String email, String name);
	
	List<User> findByNameLike(String name);
	
	List<User> findByNameOrEmail(String name, String email);
	
	List<User> findByBirthDateBetween(LocalDate begin, LocalDate end);
	
	List<User> findByNameLikeOrderByIdDesc(String name);
	
	List<User> findByNameContainingOrderByIdAsc(String name);
	
	//Named parameters 
	@Query("SELECT new com.cursoPlatzi.springboot.dto.UserDto(u.id, u.name, u.birthDate)"+
			" FROM User u "+
			"where u.birthDate=:birthDateParameter "+
			"and u.email=:emailParameter ")
	Optional<List<UserDto>>  getAllByBirthDateAndEmail(
			@Param("birthDateParameter") LocalDate date,
			@Param("emailParameter") String email);
}
 