package com.mainbord.dbmanager.model;

/**
 * Created by work on 15.02.2017.
 */

import com.sun.istack.internal.NotNull;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "user")
public class Person {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column (name = "name")
    private String name;

    @Column (name = "age")
    private int age;

/*    @Column(namme = "isAdmin", nullable = false, columnDefinition = "TINYINT(1)")*/
/*    @Column(namme = "isAdmin", nullable = false, columnDefinition = "TINYINT", length = 1)*/
/*    @Column(namme = "isAdmin", nullable = false)
    @Type(type = "org.hibernate.type.NumericBooleanType")*/
/*    @Basic
    @Column(namme = "isAdmin", columnDefinition = "BIT", length = 1)*/
/*    @Column(namme = "isAdmin", nullable = false, columnDefinition = "BIT", length = 1)*/

//    @Column (name = "isAdmin")
//@Type(type="true_false") //not working for '1' and '0' in NUMERIC(1) field
    @Type(type= "org.hibernate.type.NumericBooleanType")
    @NotNull
    @Column(name = "isAdmin", nullable = false)
    private boolean isAdmin;

    @Temporal(TemporalType.TIMESTAMP)
    @Column (name = "createdDate", columnDefinition = "1987-02-20 12:12:12")
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

    public boolean getIsAdmin() {
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

    public void setIsAdmin(boolean isAdmin) {
        this.isAdmin = isAdmin;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", namme='" + name + '\'' +
                ", age=" + age +
                ", isAdmin=" + isAdmin +
                ", createdDate=" + createdDate +
                '}';
    }
}
