package com.example.onelab.controllers;

import com.example.onelab.models.Person;
import com.example.onelab.repo.PersonRepository;
import com.example.onelab.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class PersonController {

    @Autowired
    private PersonRepository personRepository;
    private PersonService personService;

    @GetMapping("/getPeople")
    public Iterable<Person> blogMain(Model model){
        Iterable<Person> people = personRepository.findAll();
        model.addAttribute("people", people);
        return people;
    }

    @PostMapping("/persons")
    public String personAdd(@RequestParam String name, @RequestParam Integer age, Model model) {
        Person person = new Person(name, age);
        personRepository.save(person);
        return "successfully added";
    }

    @GetMapping("/showYoungPeople")
    public List<Person> findYoung(@RequestParam Integer age, Model model){
        var youngPeople = (List<Person>)personService.findByAgeLessThanEqual(age);
        model.addAttribute("young people", youngPeople);
        return youngPeople;
    }

    @GetMapping("/showOldPeople")
    public List<Person> findOld(@RequestParam Integer age, Model model){
        var oldPeople = (List<Person>)personService.findByAgeGreaterThanEqual(age);
        model.addAttribute("old people", oldPeople);
        return oldPeople;
    }
}
