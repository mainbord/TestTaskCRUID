package com.mainbord.dbmanager.controller;

import com.mainbord.dbmanager.model.Person;
import com.mainbord.dbmanager.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by work on 16.02.2017.
 */

@Controller
public class PersonController {
    private PersonService personService;

    @Autowired(required = true)
    @Qualifier(value = "personService")
    public void setPersonService(PersonService personService) {
        this.personService = personService;
    }

    @RequestMapping(value = "people", method = RequestMethod.GET)
    public String listPeople(Model model){
        model.addAttribute("person", new Person());
        model.addAttribute("listPeople", this.personService.listPeople());

        return "people";
    }

    @RequestMapping(value = "/people/add")
    public String addPerson(@ModelAttribute("person") Person person){
        if(person.getId() == 0){
            this.personService.addPerson(person);
        }
        else {
            this.personService.updatePerson(person);
        }

        return "redirect:/people";
    }

    @RequestMapping(value = "/remove/{id}")
    public String removePerson(@PathVariable("id") int id){
        this.personService.removePerson(id);
        return "redirect:/people";
    }

    @RequestMapping("edit/{id}")
    public String editPerson(@PathVariable("id") int id , Model model){
        model.addAttribute("person", this. personService.getPersonById(id));
        model.addAttribute("listPeople", this.personService.listPeople());

        return "people";
    }

    @RequestMapping("persondata/{id}")
    public String personData(@PathVariable("id") int id, Model model){
        model.addAttribute("person", this.personService.getPersonById(id));

        return "persondata";
    }
}
