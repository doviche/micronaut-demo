package it.demo.service;

import io.micronaut.core.annotation.Introspected;
import io.micronaut.serde.annotation.SerdeImport;
import it.demo.model.PersonDto;
import it.demo.persistence.entity.Person;
import it.demo.persistence.repository.PersonRepository;
import jakarta.inject.Inject;

import java.util.LinkedList;
import java.util.List;

@Introspected
@SerdeImport(PersonServiceImpl.class)
public class PersonServiceImpl implements PersonService{
    @Inject
    private PersonRepository personRepository;

    @Override
    public PersonDto save(PersonDto person) {
        Person p = new Person(person.id(), person.name(), person.age());
        p = personRepository.save(p);
        return new PersonDto(p.getId(), p.getName(), p.getAge());
    }

    @Override
    public List<PersonDto> findAll() {
        List<PersonDto> personDtoList = new LinkedList<>();
        List<Person> personList = this.personRepository.findAll();
        personList.forEach(person -> {
            personDtoList.add(new PersonDto(person.getId(), person.getName(), person.getAge()));
        });
        return personDtoList;
    }
}
