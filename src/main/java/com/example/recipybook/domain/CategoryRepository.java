package com.example.recipybook.domain;
import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;


@RepositoryRestResource
public interface CategoryRepository extends CrudRepository<Category, Long> {

    List<Category> findByName(String name);
}
