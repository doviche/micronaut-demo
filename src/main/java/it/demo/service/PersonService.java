package it.demo.service;

import it.demo.model.PersonDto;

import java.util.List;

public interface PersonService {
    PersonDto save(PersonDto person);
    List<PersonDto> findAll();
}
