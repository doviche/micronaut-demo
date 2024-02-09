package it.demo.model;

import io.micronaut.serde.annotation.SerdeImport;

@SerdeImport
        (PersonDto.class)
public record PersonDto(Integer id, String name, Integer age){
}
