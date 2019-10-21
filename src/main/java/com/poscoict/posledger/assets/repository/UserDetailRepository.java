package com.poscoict.posledger.assets.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.poscoict.posledger.assets.model.UserDetail;

@RepositoryRestResource
public interface UserDetailRepository extends CrudRepository<UserDetail, String> {
}