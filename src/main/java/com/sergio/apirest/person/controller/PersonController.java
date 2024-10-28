package com.sergio.apirest.person.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sergio.apirest.person.dto.Person;
import com.sergio.apirest.person.service.PersonService;


@RestController
@RequestMapping("/Person")
@CrossOrigin(origins = {"*"}) 
public class PersonController {
    @Autowired
    private PersonService personService;

    @PostMapping(value = "crear-persona")
    public void createPersona(@RequestBody Person person){
        personService.createPersona(person);
    }

    @GetMapping(value = "persons")
    public List<Person> getAllPersons() {
        return personService.getAllPersons();
    }

    @GetMapping(value = "get-person/{id}")
    public Person getPersonById(@PathVariable Integer id) {
        return personService.getPersonById(id);
    }
    @PutMapping(value = "update-person/{id}")
    public void updatePerson(@PathVariable Integer id, @RequestBody Person person) {
        personService.updatePerson(id, person);
    }
    @DeleteMapping(value = "delete-person/{id}")
    public void deletePerson(@PathVariable Integer id) {
        personService.deletePerson(id);
    }
    
}

