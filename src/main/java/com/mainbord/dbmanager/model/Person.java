package com.mainbord.dbmanager.model;

/**
 * Created by work on 15.02.2017.
 */
import javax.persistence.*;

@Entity
@Table
public class Person {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column (name = "name")
    private String name;

    @Column (name = "age")
    private int age;

    @Column (name = "isAdmin")
    private Boolean isAdmin;

    @Column (name = "createdDate")
    private String createdDate;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public Boolean getAdmin() {
        return isAdmin;
    }

    public String getCreatedDate() {
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

    public void setAdmin(Boolean admin) {
        isAdmin = admin;
    }

    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }
}
