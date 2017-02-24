package com.mainbord.dbmanager.model;

/**
 * Created by work on 15.02.2017.
 */
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "user")
public class Person {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column (name = "name", nullable = false)
    private String name;

    @Column (name = "age", nullable = false)
    private int age;

/*    @Column(name = "isAdmin", nullable = false, columnDefinition = "TINYINT(1)")*/
/*    @Column(name = "isAdmin", nullable = false, columnDefinition = "TINYINT", length = 1)*/
/*    @Column(name = "isAdmin", nullable = false)
    @Type(type = "org.hibernate.type.NumericBooleanType")*/
/*    @Basic
    @Column(name = "isAdmin", columnDefinition = "BIT", length = 1)*/
/*    @Column(name = "isAdmin", nullable = false, columnDefinition = "BIT", length = 1)*/
    @Column (name = "isAdmin", nullable = false)
    private int isAdmin;

    @Temporal(TemporalType.TIMESTAMP)
    @Column (name = "createdDate", nullable = false)
    private Date createdDate;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public int getisAdmin() {
        return isAdmin;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setisAdmin(int admin) {
        isAdmin = admin;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }
}
