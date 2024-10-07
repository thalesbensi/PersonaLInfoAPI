package com.example.PersonalInfoAPI.services;

import model.Person;
import org.springframework.stereotype.Service;

import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

@Service
public class PersonServices {

    private final AtomicLong counter =  new AtomicLong();
    private Logger logger = Logger.getLogger(PersonServices.class.getName());

    public Person findbyid() {

        logger.info("Finding a person!");
        Person person = new Person();
        person.setId(counter.incrementAndGet());
        person.setFirstName("Thales");
        person.setLastName("Bensi");
        person.setAdress("Rio das Ostras - Rio de Janeiro- Brasil");
        person.setGender("Male");

        return person;
    }
}
