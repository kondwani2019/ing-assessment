package com.ing.persistence;

import java.util.List;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ing.model.domain.User;

@Repository
@ComponentScan(basePackages = {"com.ing.model.domain"})
public interface UserRepository extends CrudRepository<User, Long> {
	@Query("select u from User u where u.userName = :username")
	List<User> findByUserName(@Param("username") String username);
}
