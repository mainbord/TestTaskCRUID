package com.mainbord.dbmanager.dao;

import com.mainbord.dbmanager.model.Person;
import org.hibernate.Query;
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
        System.out.println(person);
        return person;
    }


    @Override
    @SuppressWarnings("unchecked")
    public List<Person> listPeople(int pageid,int total) {
        Session session = this.sessionFactory.getCurrentSession();

/*        String sql="select * from emp limit "+(pageid-1)+","+total;
        return template.query(sql,new RowMapper<Emp>(){
            public Emp mapRow(ResultSet rs, int row) throws SQLException {
                Emp e = new Emp();
                e.setId(rs.getInt(1));
                e.setName(rs.getString(2));
                e.setSalary(rs.getFloat(3));
                return e;
            }
        });*/

        String queryString;
        queryString = "from Person";
        Query q = session.createQuery(queryString);
        q.setFirstResult(pageid - 1);
        q.setMaxResults(total);
        List<Person> personList = q.list();
        return personList;
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Person> listPeople() {
        Session session = this.sessionFactory.getCurrentSession();

        String query;
        query = "from Person";

        List<Person> personList = session.createQuery(query).list();

        return personList;
    }
}
