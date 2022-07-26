package com.qa.PersonProject.controllers;

import com.qa.PersonProject.entities.Person;
import com.qa.PersonProject.entities.PersonDTO;
import com.qa.PersonProject.services.PersonService;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.websocket.server.PathParam;
import java.util.ArrayList;
import java.util.List;

@RestController
public class PersonController {

    private PersonService service;

    public PersonController(PersonService service){
        super();
        this.service = service;
    }

    @GetMapping("/test")
    public String test(){
        return "Testing 1, 2, 3";
    }

    @GetMapping("/test2")
    public String test2(){
        return "Testing 2222";
    }

    @PostMapping("/create")
    public PersonDTO addPerson(@RequestBody @Valid Person person){

        return this.service.addPerson(person);
    }

    @GetMapping("/getAll")
    public List<PersonDTO> getAll(){

        return this.service.getAll();
    }

    @GetMapping("/getById/{id}")
    public PersonDTO getById(@PathVariable Long id){

        return this.service.getById(id);
    }

    @PutMapping("/update")
    public PersonDTO updatePerson(@PathParam("id") Long id, @RequestBody @Valid Person person){
//        this.people.remove(id);
//        this.people.add(person);
//        return this.people.get(Math.toIntExact(id));
        return this.service.updatePerson(id, person);
    }

    @DeleteMapping("/delete/{id}")
    public boolean removePerson(@PathVariable Long id) {
        // Remove Person and return it
//        return this.people.remove(id);
          return this.service.removePerson(id);
    }

}
