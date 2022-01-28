package com.juan.estevez.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import com.juan.estevez.app.entities.Person;
import com.juan.estevez.app.services.IPersonService;

/**
 * Clase encargada de controlar la gestión de personas y compartir la lógica de
 * negocio con el frontend.
 * 
 * @author Juan Carlos Estevez Vargas.
 */
@Controller
public class IndexController {

	@Autowired
	private IPersonService personService;

	/**
	 * Se encarga de listar las personas existentes en la base de datos y compartir
	 * el saldo y personas totales.
	 * 
	 * @param model.
	 * @param user   que hizo login.
	 * @return vista index.
	 */
	@GetMapping("/")
	public String home(Model model, @AuthenticationPrincipal User user) {
		var people = personService.peopleList();
		model.addAttribute("people", people);
		var totalBalance = 0D;
		for (var p : people) {
			totalBalance += p.getBalance();
		}
		model.addAttribute("totalBalance", totalBalance);
		model.addAttribute("totalPersonas", people.size());
		return "index";
	}

	/**
	 * Se encarga de redirigir a la vista de modificar.
	 * 
	 * @param person a modificar.
	 * @return vista "modify".
	 */
	@GetMapping("/add")
	public String add(Person person) {
		return "modify";
	}

	/**
	 * Se encarga de insertar una persona a la base de datos.
	 * 
	 * @param person a insertar.
	 * @param errors que ocurran en la ejecución.
	 * @return redirección al index.
	 */
	@PostMapping("/save")
	public String save(@Validated Person person, Errors errors) {
		if (errors.hasErrors()) {
			return "modify";
		}
		personService.save(person);
		return "redirect:/";
	}

	/**
	 * Se encarga de editar una persona en específico.
	 * 
	 * @param person a editar.
	 * @param model.
	 * @return vista "modify".
	 */
	@GetMapping("/edit/{idPerson}")
	public String edit(Person person, Model model) {
		person = personService.findPerson(person);
		model.addAttribute("person", person);
		return "modify";
	}

	/**
	 * Se encarga de eliminar una persona.
	 * 
	 * @param person a eliminar.
	 * @return redirección al index.
	 */
	@GetMapping("/delete")
	public String delete(Person person) {
		personService.delete(person);
		return "redirect:/";
	}
}
