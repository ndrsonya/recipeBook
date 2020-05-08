package com.example.recipybook.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface RecipyRepository extends  CrudRepository<Recipy, Long> {
	List<Recipy> findByTitle(@Param("title") String title);

}
