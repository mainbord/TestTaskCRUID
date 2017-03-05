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
    private int total = 5;
    private PersonService personService;

    @Autowired(required = true)
    @Qualifier(value = "personService")
    public void setPersonService(PersonService personService) {
        this.personService = personService;
    }

    @RequestMapping(value = "people/{pageid}", method = RequestMethod.GET)
    public String listPeople(@PathVariable int pageid, Model model){

        if(pageid!=1){ pageid=(pageid-1)*total+1; }

        model.addAttribute("person", new Person());
        model.addAttribute("listPeople", this.personService.listPeople(pageid, total));
        model.addAttribute("hhh", this.personService.hhh(total));
        return "people";
    }

    @RequestMapping(value = "/people/add", method = RequestMethod.POST)
    public String addPerson(@ModelAttribute("person") Person person){
        if(person.getId() == 0){
            this.personService.addPerson(person);
        }else {
            this.personService.updatePerson(person);
        }

        return "people";
    }


    @RequestMapping(value = "/remove/{id}")
    public String removePerson(@PathVariable("id") int id){
        this.personService.removePerson(id);
        return "people";
    }


    @RequestMapping("/edit/{id}")
    public String editPerson(@PathVariable("id") int id, Model model){
        model.addAttribute("person", this.personService.getPersonById(id));
        int aa = 0;
        for (int i = 0; i < this.personService.listPeople().size(); i++) {
            if (this.personService.listPeople().get(i).getId() == id){
                aa = ((i/ total)) * total;
            }
        }
        System.out.println("------------- " + this.personService.listPeople().get(aa).getId());
        model.addAttribute("listPeople", this.personService.listPeople(this.personService.listPeople().get(aa).getId(), total));

        return "people";
    }

    @RequestMapping("/persondata/{id}")
    public String personData(@PathVariable("id") int id, Model model){
        model.addAttribute("person", this.personService.getPersonById(id));

        return "persondata";
    }


}
