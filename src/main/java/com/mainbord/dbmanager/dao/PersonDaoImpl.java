package com.mainbord.dbmanager.dao;

import com.mainbord.dbmanager.model.Person;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import java.util.List;
/**
 * Created by work on 15.02.2017.
 */
@Repository
public class PersonDaoImpl implements PersonDao {

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void addPerson(Person person) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(person);
    }

    @Override
    public void updatePerson(Person person) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(person);
    }

    @Override
    public void removePerson(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Person person = (Person) session.load(Person.class, new Integer(id));

        if (person != null){
            session.delete(person);
        }
    }

    @Override
    public Person getPersonById(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Person person = (Person) session.load(Person.class, new Integer(id));
        return person;
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Person> listPeople() {
        Session session = this.sessionFactory.getCurrentSession();
        List<Person> personList = session.createQuery("from Person").list();

        return personList;
    }
}
