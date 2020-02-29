package com.github.watchyouss.instDataProcessor.controller;

import com.github.watchyouss.instDataProcessor.controller.interfaces.SearchController;
import com.github.watchyouss.instDataProcessor.dto.Person;
import com.github.watchyouss.instDataProcessor.service.interfaces.Finder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/search")
public class PersonSearchController implements SearchController {

    private final Finder personFinder;

    @Autowired
    public PersonSearchController(Finder personFinder) {
        this.personFinder = personFinder;
    }

    @Override
    @RequestMapping(path = "/person/{personName}")
    public Person findPersonByName(
        @PathVariable("personName")
            String personName) {
        return personFinder.findByName(personName);
    }
}
