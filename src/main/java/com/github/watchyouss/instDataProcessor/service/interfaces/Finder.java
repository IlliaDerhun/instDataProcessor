package com.github.watchyouss.instDataProcessor.service.interfaces;

import com.github.watchyouss.instDataProcessor.dto.Person;

public interface Finder {
    Person findByName(String firstName);
}
