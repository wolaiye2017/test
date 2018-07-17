package com.test.hibernate.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "t_user")
@GenericGenerator(name = "generator",strategy="increment")
public class User {

    @Id
    @GeneratedValue(generator = "generator")
    private Long userId;
    @Column(name = "u_name")
    private String name;

    @ManyToOne(fetch = FetchType.LAZY,targetEntity = Department.class)
    @JoinColumn(name = "departmentId")
    private Department department;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", name='" + name + '\'' +
                ", department=" + department +
                '}';
    }
}
