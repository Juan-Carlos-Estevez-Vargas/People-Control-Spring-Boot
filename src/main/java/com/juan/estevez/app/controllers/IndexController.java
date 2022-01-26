package com.juan.estevez.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import com.juan.estevez.app.entities.Person;
import com.juan.estevez.app.services.IPersonService;

@Controller
public class IndexController {
    
    @Autowired
    private IPersonService personService;
    
    @GetMapping("/")
    public String home(Model model){
        var people = personService.peopleList();
        model.addAttribute("people", people);
        return "index";
    }
    
    @GetMapping("/add")
    public String add(Person person){
        return "modify";
    }
    
    @PostMapping("/save")
    public String save(@Validated Person person, Errors errors){
        if(errors.hasErrors()){
            return "modify";
        }
        personService.save(person);
        return "redirect:/";
    }
    
    @GetMapping("/edit/{idPerson}")
    public String edit(Person person, Model model){
        person = personService.findPerson(person);
        model.addAttribute("person", person);
        return "modify";
    }
    
    @GetMapping("/delete")
    public String delete(Person person){
        personService.delete(person);
        return "redirect:/";
    }
}
