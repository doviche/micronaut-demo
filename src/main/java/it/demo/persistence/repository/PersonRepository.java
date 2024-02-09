package it.demo.persistence.repository;

import io.micronaut.data.annotation.Repository;
import io.micronaut.data.repository.CrudRepository;
import it.demo.persistence.entity.Person;

@Repository
public interface PersonRepository extends CrudRepository<Person, Integer> {
}