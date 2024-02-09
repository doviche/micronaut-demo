package it.demo.repository;

import io.micronaut.data.annotation.Repository;
import io.micronaut.data.repository.CrudRepository;
import it.demo.model.Person;

@Repository
public interface PersonRepository extends CrudRepository<Person, Integer> {
}