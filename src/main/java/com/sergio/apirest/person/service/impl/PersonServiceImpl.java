package com.sergio.apirest.person.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sergio.apirest.person.dto.Person;
import com.sergio.apirest.person.repository.PersonRepository;
import com.sergio.apirest.person.service.PersonService;


@Service

public class PersonServiceImpl implements PersonService {
    @Autowired
    private PersonRepository personRepo;

    public void createPersona(Person person) {
        personRepo.createPersona(person);
    }

    public List<Person> getAllPersons() {
        return personRepo.getAllPersons();
    }

    // Método para obtener una persona por su ID
    public Person getPersonById(Integer id) {
        return personRepo.getPersonById(id);
    }
    public void updatePerson(Integer id, Person person) {
            personRepo.updatePerson(id,person);
    
    }
    public void deletePerson(Integer id) {
            personRepo.deletePerson(id);
    }
    
    
}

