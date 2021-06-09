package com.example.onelab.repo;

import com.example.onelab.models.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {
    List<Person> findByAgeLessThanEqual(Integer age);
    List<Person> findByAgeGreaterThanEqual(Integer age);
}
