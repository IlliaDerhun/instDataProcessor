package com.github.watchyouss.instDataProcessor.dto;

import com.fasterxml.jackson.annotation.JsonCreator;

import java.util.Objects;

public class Person {

    private final String firstName;

    @JsonCreator
    public Person(String firstName) {
        this.firstName = firstName;
    }

    public String getFirstName() {
        return firstName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Person person = (Person) o;
        return Objects.equals(firstName, person.firstName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName);
    }

    @Override
    public String toString() {
        return "Person{" + "firstName='" + firstName + '\'' + '}';
    }
}
