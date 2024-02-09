package it.demo.model;

import io.micronaut.serde.annotation.SerdeImport;

@SerdeImport
        (Message.class)
public record Message (int code, String description){
}
