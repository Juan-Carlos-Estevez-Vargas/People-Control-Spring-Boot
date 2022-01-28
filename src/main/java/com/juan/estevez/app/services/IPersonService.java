package com.juan.estevez.app.services;

import java.util.List;
import com.juan.estevez.app.entities.Person;

/**
 * Interfaz encargada de realizar operaciones crud con una persona.
 * 
 * @author Juan Carlos Estevez Vargas.
 */
public interface IPersonService {

	/**
	 * Se encarga de listar las personas directamente desde la base de datos.
	 * 
	 * @return lista de personas obtenida.
	 */
	public List<Person> peopleList();

	/**
	 * Se encarga de insertar o actualizar una persona directamente a la base de
	 * datos.
	 * 
	 * @param person a insertar o actualizar.
	 */
	public void save(Person person);

	/**
	 * Se encarga de eliminar una persona directamente de la base de datos.
	 * 
	 * @param person a eliminar.
	 */
	public void delete(Person person);

	/**
	 * Se encarga de buscar una persona directamente de la base de datos
	 * 
	 * @param person a buscar
	 * @return persona encontrada
	 */
	public Person findPerson(Person person);
}
