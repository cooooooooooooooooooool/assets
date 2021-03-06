package com.poscoict.posledger.assets.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.poscoict.posledger.assets.model.User;

@RepositoryRestResource
public interface UserRepository extends CrudRepository<User, String> {
	
	@Override
    List<User> findAll();
}