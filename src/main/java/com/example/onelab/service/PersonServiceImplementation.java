package com.example.onelab.service;

import com.example.onelab.models.Person;
import com.example.onelab.repo.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class PersonServiceImplementation implements PersonService {

    @Autowired
    private PersonRepository personRepository;

    @Override
    public List<Person> findByAgeLessThanEqual(Integer age) {
        var youngPeople = (List<Person>)personRepository.findByAgeLessThanEqual(age);
        return youngPeople;
    }

    @Override
    public List<Person> findByAgeGreaterThanEqual(Integer age) {
        var oldPeople = (List<Person>)personRepository.findByAgeGreaterThanEqual(age);
        return oldPeople;
    }
}
