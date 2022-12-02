package com.example.coursesManagement.models;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "department")
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long did;
    private String name;
    private String description;


    @OneToMany(mappedBy = "department", cascade = CascadeType.ALL)
    private Set<Course> courses;

    @OneToMany(mappedBy = "department", cascade = CascadeType.ALL)
    private Set<Teacher> teachers;


    public Department() {

    }

    public Department(Long did, String name, String description) {
        this.did = did;
        this.name = name;
        this.description = description;
    }

    public Department(Long did, String name, String description, Set<Course> courses, Set<Teacher> teachers) {
        this.did = did;
        this.name = name;
        this.description = description;
        this.courses = courses;
        this.teachers = teachers;

    }

    public Department(String name, String description, Set li, Set li1, Set li2) {
    }

    public Long getDid() {
        return did;
    }

    public void setDid(Long did) {
        this.did = did;
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

    public Set<Course> getCourses() {
        return courses;
    }

    public void setCourses(Set<Course> courses) {
        this.courses = courses;
    }

    public Set<Teacher> getTeachers() {
        return teachers;
    }

    public void setTeachers(Set<Teacher> teachers) {
        this.teachers = teachers;
    }
}
