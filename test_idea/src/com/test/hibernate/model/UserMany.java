package com.test.hibernate.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "t_user_many")
@GenericGenerator(name = "generator",strategy="increment")
public class UserMany {
    @Id
    @GeneratedValue(generator = "generator")
    private long userId;

    @Column(name = "um_name")
    private String name;

    @ManyToMany(fetch = FetchType.LAZY,targetEntity = Role.class)
    @JoinTable(name = "tb_user_role",joinColumns = @JoinColumn(name = "userId"),inverseJoinColumns = @JoinColumn(name = "roleId"))
    private Set<Role> roles;

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    @Override
    public String toString() {
        return "UserMany{" +
                "userId=" + userId +
                ", name='" + name + '\'' +
                '}';
    }
}
