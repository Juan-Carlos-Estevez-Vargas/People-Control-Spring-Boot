package com.juan.estevez.app.services;

import java.util.List;

import com.juan.estevez.app.entities.Person;

public interface IPersonService {
    
    public List<Person> peopleList();
    
    public void save(Person person);
    
    public void delete(Person person);
    
    public Person findPerson(Person person);
}
