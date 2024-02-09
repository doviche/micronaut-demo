package it.demo.resource;

import io.micronaut.context.ApplicationContext;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.HttpStatus;
import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Post;
import it.demo.model.Message;
import it.demo.model.PersonDto;
import it.demo.service.PersonService;
import it.demo.service.PersonServiceImpl;
import jakarta.inject.Inject;

@Controller("/persons")
public class PersonResource {
    @Inject
    private ApplicationContext appContext;

    @Post()
    public HttpResponse<Message> savePerson(@Body PersonDto person) {
        PersonService personService =  appContext.getBean(PersonServiceImpl.class);
        personService.save(person);
        return HttpResponse.status(HttpStatus.CREATED).body(new Message(HttpStatus.CREATED.getCode(),"Saved successfully !"));
    }

    @Get()
    public HttpResponse<?> getPersons() {
        PersonService personService =  appContext.getBean(PersonServiceImpl.class);
        return HttpResponse.status(HttpStatus.OK).body(personService.findAll());
    }
}
