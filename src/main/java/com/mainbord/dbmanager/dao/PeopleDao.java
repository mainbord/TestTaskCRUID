package com.mainbord.dbmanager.dao;

import com.mainbord.dbmanager.model.Person;

import java.util.List;

/**
 * Created by work on 15.02.2017.
 */
public interface PeopleDao {
    public void addPerson (Person person);
    public void updatePerson (Person person);
    public void removePerson (int id);
    public Person getPersonById (int id);
    public List<Person> listPeople();
}
