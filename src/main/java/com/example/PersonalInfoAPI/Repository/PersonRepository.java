package com.example.PersonalInfoAPI.Repository;


import com.example.PersonalInfoAPI.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {

}
