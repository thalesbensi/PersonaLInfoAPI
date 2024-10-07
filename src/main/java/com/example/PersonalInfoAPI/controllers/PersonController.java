package com.example.PersonalInfoAPI.controllers;

import com.example.PersonalInfoAPI.services.PersonServices;
import model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/person")
public class PersonController {

    @Autowired
    private PersonServices service;
    //private PersonServices service = new PersonServices(); <-- Before Autowired

    @RequestMapping(method= RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public List findAll(){
        return service.findAll();
    }

    @RequestMapping(value = "{id}",
            method= RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public Person findbyId(@PathVariable(value = "id")String id) throws Exception{
        return service.findbyid(id);
    }



}
