package com.juan.estevez.app.repositories;

import org.springframework.data.repository.CrudRepository;
import com.juan.estevez.app.entities.Person;

/**
 * Repositorio encargado de gestionar las operaciones CRUD de una persona.
 * 
 * @author Juan Carlos Estevez Vargas.
 */
public interface IPersonRepository extends CrudRepository<Person, Long> {
}