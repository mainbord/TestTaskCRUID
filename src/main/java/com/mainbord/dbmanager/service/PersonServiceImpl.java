package com.mainbord.dbmanager.service;

import com.mainbord.dbmanager.dao.PeopleDao;
import com.mainbord.dbmanager.model.Person;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by work on 15.02.2017.
 */
@Service
public class PersonServiceImpl implements  PersonService{

    private PeopleDao peopleDao;

    @Transactional
    public void setPeopleDao(PeopleDao peopleDao) {
        this.peopleDao = peopleDao;
    }

    @Transactional
    public void addPerson(Person person) {
        this.peopleDao.addPerson(person);
    }

    @Transactional
    public void updatePerson(Person person) {
        this.peopleDao.updatePerson(person);
    }

    @Transactional
    public void removePerson(int id) {
        this.peopleDao.removePerson(id);
    }

    @Transactional
    public Person getPersonById(int id) {

        return this.peopleDao.getPersonById(id);
    }

    @Transactional
    public List<Person> listPeople() {
        return this.peopleDao.listPeople();
    }
}
