package com.juan.estevez.app.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.juan.estevez.app.entities.Person;
import com.juan.estevez.app.repositories.IPersonRepository;

/**
 * Servicio encargado de realizar la lógica de negocio de la aplicación uniendo
 * la el repositorio con el servicio.
 * 
 * @author Juan Carlos Estevez Vargas.
 */
@Service
public class PersonaServiceImpl implements IPersonService {

	@Autowired
	private IPersonRepository personRepository;

	@Override
	@Transactional(readOnly = true)
	public List<Person> peopleList() {
		return (List<Person>) personRepository.findAll();
	}

	@Override
	@Transactional
	public void save(Person person) {
		personRepository.save(person);
	}

	@Override
	@Transactional
	public void delete(Person person) {
		personRepository.delete(person);
	}

	@Override
	@Transactional(readOnly = true)
	public Person findPerson(Person person) {
		return personRepository.findById(person.getIdPerson()).orElse(null);
	}
}
