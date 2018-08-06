package com.milton.cursospring.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.milton.cursospring.entity.User;

public interface UserRepository extends MongoRepository<User, Long> {

	public User findByName(String name);
	
	@Query("{ 'email' : ?0 }")
	public User findByEmailProprio(String email);

//	public User findByEmail(String email);
//	@Query("select u from User u where u.email like %?1%")
//	public List<User> findByPartialEmail(String email);
	// Spring Data Documentation, diversos exemplos de buscaPronta JPA
	public User findByNameIgnoreCaseLike(String name);

}
