package com.test.hibernate.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "t_role")
@GenericGenerator(name = "generator",strategy="increment")
public class Role {

    @Id
    @GeneratedValue(generator ="generator" )
    private long roleId;
    @Column(name = "r_name")
    private String name;

    @ManyToMany(targetEntity = UserMany.class,fetch = FetchType.LAZY,mappedBy = "roles")
    private Set<UserMany> userManies;

    public long getRoleId() {
        return roleId;
    }

    public void setRoleId(long roleId) {
        this.roleId = roleId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<UserMany> getUserManies() {
        return userManies;
    }

    public void setUserManies(Set<UserMany> userManies) {
        this.userManies = userManies;
    }

    @Override
    public String toString() {
        return "Role{" +
                "roleId=" + roleId +
                ", name='" + name + '\'' +
                '}';
    }
}
