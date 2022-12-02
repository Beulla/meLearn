package com.example.coursesManagement.controllers;

import com.example.coursesManagement.dto.CourseDTO;
import com.example.coursesManagement.dto.TeacherDTO;
import com.example.coursesManagement.models.Course;
import com.example.coursesManagement.models.Teacher;
import com.example.coursesManagement.repositories.CourseRepository;
import com.example.coursesManagement.services.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/teachers")
@CrossOrigin(origins = "http://localhost:4200")
public class TeacherController {
    @Autowired
    private TeacherService teacherService;

    @Autowired
    private CourseRepository courseRepository;

    @GetMapping("")
    @ResponseBody()
    public Iterable<Teacher> getAllTeachers(){
        return teacherService.getAllTeachers();
    }

    @GetMapping("/courses")
    @ResponseBody()
    public List<Course> getCourse(){
        List<Course> courses=new ArrayList<>();
        courseRepository.findAll().forEach(courses::add);
        return courses;
    }

    @RequestMapping(value = "/teacher/{teacherID}",method = RequestMethod.GET)
    @ResponseBody()
    public Optional<Teacher> getTeacher(@PathVariable("teacherID") Long teacherID){
        return teacherService.getTeacher(teacherID);
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    @ResponseBody()
    public Teacher createTeacher(@Validated @RequestBody TeacherDTO teacher){
        return teacherService.createTeacher(teacher);
    }
    @RequestMapping(value = "/teachers/{id}", method = RequestMethod.DELETE)
    @ResponseBody()
    public void deleteTeacher(@Validated @RequestBody Long tId){
        teacherService.deleteTeacher(tId);
    }

    @RequestMapping(value = "/{id}/courses", method = RequestMethod.GET)
    @ResponseBody
    public List<CourseDTO> getCoursesForTeacher(@PathVariable Long id){
        return teacherService.getCoursesForTeacher(id);
    }
}
