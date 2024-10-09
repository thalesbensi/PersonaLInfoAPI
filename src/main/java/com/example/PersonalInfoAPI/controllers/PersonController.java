package com.example.PersonalInfoAPI.controllers;

import com.example.PersonalInfoAPI.services.PersonServices;
import com.example.PersonalInfoAPI.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/person")
public class PersonController {

    @Autowired
    private PersonServices service;

    @RequestMapping(method= RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public List findAll(){
        return service.findAll();
    }

    @RequestMapping(value = "{id}",
            method= RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public Person findbyId(@PathVariable(value = "id")Long id) throws Exception{
        return service.findbyid(id);
    }

    @RequestMapping(method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public Person create (@RequestBody Person person){
        return service.create(person);
    }

    @RequestMapping(method = RequestMethod.PUT,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public Person update (@RequestBody Person person){
        return service.update(person);
    }

    @RequestMapping(value = "{id}",
            method= RequestMethod.DELETE)
    public void delete(@PathVariable(value = "id")Long id) throws Exception{
         service.delete(id);
    }
}
