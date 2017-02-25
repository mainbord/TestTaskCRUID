package com.mainbord.dbmanager.model;

/**
 * Created by work on 15.02.2017.
 */

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "user")
public class Person {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idd;

    @Column (name = "name")
    private String name;

    @Column (name = "age")
    private int agge;

/*    @Column(namme = "isAdmin", nullable = false, columnDefinition = "TINYINT(1)")*/
/*    @Column(namme = "isAdmin", nullable = false, columnDefinition = "TINYINT", length = 1)*/
/*    @Column(namme = "isAdmin", nullable = false)
    @Type(type = "org.hibernate.type.NumericBooleanType")*/
/*    @Basic
    @Column(namme = "isAdmin", columnDefinition = "BIT", length = 1)*/
/*    @Column(namme = "isAdmin", nullable = false, columnDefinition = "BIT", length = 1)*/
    @Column (name = "isAdmin")
    private int isAdmin;

    @Temporal(TemporalType.TIMESTAMP)
    @Column (name = "createdDate", columnDefinition = "1987-02-20 12:12:12")
    private Date createdDate;

    public int getIdd() {
        return idd;
    }

    public String getName() {
        return name;
    }

    public int getAgge() {
        return agge;
    }

    public int getIsAdmin() {
        return isAdmin;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setIdd(int idd) {
        this.idd = idd;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAgge(int agge) {
        this.agge = agge;
    }

    public void setIsAdmin(int isAdmin) {
        this.isAdmin = isAdmin;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    @Override
    public String toString() {
        return "Person{" +
                "idd=" + idd +
                ", namme='" + name + '\'' +
                ", agge=" + agge +
                ", isAdmin=" + isAdmin +
                ", createdDate=" + createdDate +
                '}';
    }
}
