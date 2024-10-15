package com.example.PersonalInfoAPI.controllers;


import com.example.PersonalInfoAPI.data.vo.v1.PersonVO;
import com.example.PersonalInfoAPI.data.vo.v2.PersonVOV2;
import com.example.PersonalInfoAPI.mapper.custom.PersonMapper;
import com.example.PersonalInfoAPI.services.PersonServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/person/v1")
public class PersonController {

    @Autowired
    public PersonServices service;


    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List findAll(){
        return service.findAll();
    }

    @GetMapping(value = "{id}",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public PersonVO findbyId(@PathVariable(value = "id")Long id) throws Exception{
        return service.findById(id);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public PersonVO create (@RequestBody PersonVO person){
        return service.create(person);
    }

    @PostMapping(value = "/v2",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public PersonVOV2 createV2 (@RequestBody PersonVOV2 person){
        return service.createV2(person);
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public PersonVO update (@RequestBody PersonVO person){
        return service.update(person);
    }

    @DeleteMapping(value = "{id}")
    public ResponseEntity<?> delete(@PathVariable(value = "id")Long id) throws Exception{
         service.delete(id);
         return ResponseEntity.noContent().build();
    }
}
