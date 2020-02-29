package com.github.watchyouss.instDataProcessor.controller.interfaces;

import com.github.watchyouss.instDataProcessor.dto.Person;

public interface SearchController extends Controller {
    Person findPersonByName(String personName);
}
