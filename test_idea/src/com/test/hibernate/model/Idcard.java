package com.test.hibernate.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "t_id_card")
@GenericGenerator(name = "generator",strategy="increment")
public class Idcard {
    @Id
    @GeneratedValue(generator = "generator")
    private int idcardId;

    @Column(name = "i_name")
    private String name;

    @OneToOne(fetch = FetchType.LAZY,targetEntity = Person.class)
    @JoinColumn(name = "personId",unique = true)
    private Person person;

    public int getId() {
        return idcardId;
    }

    public void setId(int id) {
        this.idcardId = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    @Override
    public String toString() {
        return "Idcard{" +
                "id=" + idcardId +
                ", name='" + name + '\'' +"" +
                '}';
    }
}
