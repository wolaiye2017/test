package com.test.hibernate.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "t_person")
@GenericGenerator(name = "generator",strategy="increment")
public class Person {

    @Id
    @GeneratedValue(generator = "generator")
    private int personId;

    @Column(name = "p_name")
    private String name;

    @OneToOne(fetch = FetchType.LAZY,targetEntity = Idcard.class,mappedBy = "person")
    private Idcard idcard;

    public int getId() {
        return personId;
    }

    public void setId(int id) {
        this.personId = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Idcard getIdcard() {
        return idcard;
    }

    public void setIdcard(Idcard idcard) {
        this.idcard = idcard;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + personId +
                ", name='" + name + '\'' +
                ", idcard=" + idcard +
                '}';
    }
}
