package com.example.PersonalInfoAPI.services;

import model.Person;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

@Service
public class PersonServices {

    private final AtomicLong counter =  new AtomicLong();
    private Logger logger = Logger.getLogger(PersonServices.class.getName());

    public Person findbyid(String id) {

        logger.info("Finding a person!");
        Person person = new Person();
        person.setId(counter.incrementAndGet());
        person.setFirstName("Thales");
        person.setLastName("Bensi");
        person.setAdress("Rio das Ostras - Rio de Janeiro- Brasil");
        person.setGender("Male");

        return person;
    }

    public List findAll() {

        logger.info("Finding all people!");
        List<Person> persons = new ArrayList<>();
        for (int i = 0; i < 8; i++){
            Person person = mockPerson(i);
            persons.add(person);
        }

        return persons;
    }

    public Person create (Person person){
        logger.info("Creating a person!");
        return person;
    }

    public Person update (Person person){
        logger.info("Updating a person!");
        return person;
    }

    public void delete (String id){
        logger.info("Deleting a person!");
    }



    private Person mockPerson(int i) {
        Person person = new Person();
        person.setId(counter.incrementAndGet());
        person.setFirstName("Thales" + i);
        person.setLastName("Bensi" + i);
        person.setAdress("Some adress in Brasil" + i);
        person.setGender((i % 2 == 0) ? "Male" : "Female");;

        return person;
    }

}
