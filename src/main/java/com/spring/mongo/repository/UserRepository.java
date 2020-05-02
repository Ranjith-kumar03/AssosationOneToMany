package com.spring.mongo.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.web.bind.annotation.PathVariable;

import com.spring.mongo.model.User;

public interface UserRepository extends MongoRepository<User, Integer> {
	
public  List<User> findByName(String name);

@Query("{'Address.city':?0}")
public List<User>  findUserByAddressCity(String city);

}
