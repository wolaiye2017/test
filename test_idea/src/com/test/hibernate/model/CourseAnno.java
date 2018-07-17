package com.test.hibernate.model;


import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "test_cours")
public class CourseAnno {

    @Id
    @GenericGenerator(name = "generator",strategy="increment")
    @GeneratedValue(generator="generator")
    private int id;

    @Column(name="name")
    private String name;

    @Column(name="description")
    private String description;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "CourseAnno{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
