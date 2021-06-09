package com.example.onelab.service;

import com.example.onelab.models.Person;

import java.util.List;

public interface PersonService {
    List<Person> findByAgeLessThanEqual(Integer age);
    List<Person> findByAgeGreaterThanEqual(Integer age);
}
