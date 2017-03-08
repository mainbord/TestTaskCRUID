package com.mainbord.dbmanager.service;

import com.mainbord.dbmanager.dao.PersonDao;
import com.mainbord.dbmanager.model.Person;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by work on 15.02.2017.
 */
@Service
public class PersonServiceImpl implements  PersonService{

    private PersonDao personDao;

    public void setPersonDao(PersonDao personDao) {
        this.personDao = personDao;
    }

    @Override
    @Transactional
    public void addPerson(Person person) {

        System.out.println("----------------------------- "  + "addddddddddddddd");
        this.personDao.addPerson(person);
    }

    @Override
    @Transactional
    public void updatePerson(Person person) {
        this.personDao.updatePerson(person);
    }

    @Override
    @Transactional
    public void removePerson(int id) {this.personDao.removePerson(id);}

    @Override
    @Transactional
    public Person getPersonById(int id) {return this.personDao.getPersonById(id);}

    @Override
    @Transactional
    public List<Person> listPeople(int pageid,int total) {
        return this.personDao.listPeople(pageid, total);
    }

    @Override
    @Transactional
    public List<Person> listPeople() {
        return this.personDao.listPeople();
    }

    @Override
    @Transactional
    public String hhh(int total) {
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < listPeople().size() / 5 + 2; i++) {
        sb.append("<a href=\"/people/" + i + "\">" + i + "</a>");
        sb.append("\n");
        }
        return sb.toString();
    }

    @Override
    @Transactional
    public List<Person> filterPeople(String name) {
        return this.personDao.filterPeople(name);
    }
}
