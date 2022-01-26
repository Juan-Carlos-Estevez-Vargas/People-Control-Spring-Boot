package com.juan.estevez.app.repositories;

import org.springframework.data.repository.CrudRepository;
import com.juan.estevez.app.entities.Person;

public interface IPersonRepository extends CrudRepository<Person, Long>{
}