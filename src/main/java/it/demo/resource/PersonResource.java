package it.demo.resource;

import io.micronaut.http.HttpResponse;
import io.micronaut.http.HttpStatus;
import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Post;
import it.demo.model.Message;
import it.demo.model.Person;
import it.demo.repository.PersonRepository;
import jakarta.inject.Inject;

@Controller("/persons")
public class PersonResource {
    @Inject
    private PersonRepository personRepository;

    @Post()
    public HttpResponse<Message> savePerson(@Body Person person) {
        this.personRepository.save(person);
        return HttpResponse.status(HttpStatus.CREATED).body(new Message(HttpStatus.CREATED.getCode(),"Saved successfully !"));
    }

    @Get()
    public HttpResponse<?> getPersons() {
        return HttpResponse.status(HttpStatus.OK).body(this.personRepository.findAll());
    }
}
