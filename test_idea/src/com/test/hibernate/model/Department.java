package com.test.hibernate.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "t_dement")
@GenericGenerator(name = "generator",strategy="increment")
public class Department {

    @Id
    @GeneratedValue(generator = "generator")
    private Long departmentId;

    @Column(name = "t_name")
    private String name;
    @OneToMany(fetch = FetchType.LAZY,targetEntity = User.class,mappedBy = "department")
    private Set<User> users;

    public Long getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Long departmentId) {
        this.departmentId = departmentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

    @Override
    public String toString() {
        return "Department{" +
                "departmentId=" + departmentId +
                ", name='" + name + '\'' +

                '}';
    }
}
