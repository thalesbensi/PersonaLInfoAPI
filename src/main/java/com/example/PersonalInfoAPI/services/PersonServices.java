package com.example.PersonalInfoAPI.services;


import com.example.PersonalInfoAPI.Repository.PersonRepository;
import com.example.PersonalInfoAPI.exceptions.ResourceNotFoundException;
import com.example.PersonalInfoAPI.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.Logger;


@Service
public class PersonServices {

    private Logger logger = Logger.getLogger(PersonServices.class.getName());

    @Autowired
    private PersonRepository repository;

    public Person findbyid(Long id) {

        logger.info("Finding a person!");
        return repository.findById(id).orElseThrow(
                ()-> new ResourceNotFoundException("No records found for this ID"));
    }

    public List findAll() {

        logger.info("Finding all people!");
        return repository.findAll();
    }

    public Person create (Person person){
        logger.info("Creating a person!");
        return repository.save(person);
    }

    public Person update (Person person){
        logger.info("Updating a person!");

        Person entity = repository.findById(person.getId()).orElseThrow(
                ()-> new ResourceNotFoundException("No records found for this ID"));

        entity.setFirstName(person.getFirstName());
        entity.setLastName(person.getLastName());
        entity.setAdress(person.getAdress());
        entity.setGender(person.getGender());;

        return repository.save(person);
    }

    public void delete (Long id){
        logger.info("Deleting a person!");
        Person entity = repository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("No records found for this ID"));
        repository.delete(entity);
    }


}
