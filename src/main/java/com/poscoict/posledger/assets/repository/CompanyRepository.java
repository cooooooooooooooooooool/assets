package com.poscoict.posledger.assets.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.poscoict.posledger.assets.model.Company;

@RepositoryRestResource(collectionResourceRel = "companys", path = "companys", exported=true)
public interface CompanyRepository extends PagingAndSortingRepository<Company, Long> {
}