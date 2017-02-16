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

    @Transactional
    public void setPersonDao(PersonDao personDao) {
        this.personDao = personDao;
    }

    @Transactional
    public void addPerson(Person person) {
        this.personDao.addPerson(person);
    }

    @Transactional
    public void updatePerson(Person person) {
        this.personDao.updatePerson(person);
    }

    @Transactional
    public void removePerson(int id) {
        this.personDao.removePerson(id);
    }

    @Transactional
    public Person getPersonById(int id) {

        return this.personDao.getPersonById(id);
    }

    @Transactional
    public List<Person> listPeople() {
        return this.personDao.listPeople();
    }
}
