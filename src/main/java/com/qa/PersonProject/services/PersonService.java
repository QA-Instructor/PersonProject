package com.qa.PersonProject.services;

import com.qa.PersonProject.entities.Person;
import com.qa.PersonProject.entities.PersonDTO;
import com.qa.PersonProject.entities.PersonRepo;
import com.qa.PersonProject.exceptions.PersonNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import javax.validation.Valid;
import javax.websocket.server.PathParam;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PersonService {

private PersonRepo repo;
private ModelMapper mapper;

public PersonService(PersonRepo repo, ModelMapper mapper){
    super();
    this.repo = repo;
    this.mapper = mapper;
}

private PersonDTO mapToDTO(Person person){
    return this.mapper.map(person, PersonDTO.class);
}

    public String test(){
        return "Testing 1, 2, 3";
    }


    public PersonDTO addPerson( Person person){

//        this.people.add(person);
//        return this.people.get(this.people.size()-1);
        Person saved = this.repo.save(person);
        return this.mapToDTO(saved);
    }


    public List<PersonDTO> getAll(){

//    return this.people;
//    return this.repo.findAll();
        return this.repo.findAll().stream().map(this::mapToDTO).collect(Collectors.toList());
}

    public PersonDTO getById(Long id){

//    return this.people;
//    return this.repo.findAll();
        Person found =  this.repo.findById(id).orElseThrow(PersonNotFoundException::new);
        return this.mapToDTO(found);
    }


    public PersonDTO updatePerson(Long id, Person person){

        Optional<Person> existingOptional = this.repo.findById(id);
        Person existing = existingOptional.get();
        existing.setAge(person.getAge());
        existing.setFirstname(person.getFirstname());
        existing.setLastname(person.getLastname());
        Person updated =  this.repo.save(existing);
        return this.mapToDTO(updated);
    }


    public boolean removePerson(Long id) {
        // Remove Person and return it
//        return this.people.remove(id);
        this.repo.deleteById(id);
        boolean exists = this.repo.existsById(id);
        return !exists;
    }
}
