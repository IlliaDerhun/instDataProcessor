package com.github.watchyouss.instDataProcessor.service;

import com.github.watchyouss.instDataProcessor.dto.Person;
import com.github.watchyouss.instDataProcessor.service.interfaces.Finder;
import org.springframework.stereotype.Service;

@Service
public class PersonFinder implements Finder {
    @Override
    public Person findByName(String firstName) {
        return new Person(firstName);
    }
}
