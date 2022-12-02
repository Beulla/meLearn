package com.example.coursesManagement.dto;

public class DepartmentDTO {
    private String name;
    private String description;
    private int[] courses;
    private int[] teachers;

    public DepartmentDTO(){}
    public DepartmentDTO(String name, String description, int[] courses, int[] teachers) {
        this.name = name;
        this.description = description;
        this.courses = courses;
        this.teachers = teachers;
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

    public int[] getCourses() {
        return courses;
    }

    public void setCourses(int[] courses) {
        this.courses = courses;
    }

    public int[] getTeachers() {
        return teachers;
    }

    public void setTeachers(int[] teachers) {
        this.teachers = teachers;
    }
}
