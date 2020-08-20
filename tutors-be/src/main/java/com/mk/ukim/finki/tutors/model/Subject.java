package com.mk.ukim.finki.tutors.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "subjects")
public class Subject {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    @ManyToMany(mappedBy = "subjects", fetch = FetchType.LAZY)
    private List<UserDetailed> userDetailedList;

    public Subject() {
    }

    public List<UserDetailed> getUserDetailedList() {
        return userDetailedList;
    }

    public void setUserDetailedList(List<UserDetailed> userDetailedList) {
        this.userDetailedList = userDetailedList;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
