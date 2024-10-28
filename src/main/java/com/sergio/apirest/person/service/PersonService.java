package com.sergio.apirest.person.service;

import java.util.List;

import com.sergio.apirest.person.dto.Person;

public interface PersonService {

    public void createPersona(Person person);
    
    public List<Person> getAllPersons();

    public Person getPersonById(Integer id);

    public void updatePerson(Integer id, Person person);
    
    public void deletePerson(Integer id);
} 