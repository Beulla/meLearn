package com.example.coursesManagement.controllers;

import com.example.coursesManagement.dto.CourseDTO;
import com.example.coursesManagement.models.Course;
import com.example.coursesManagement.repositories.CourseRepository;
import com.example.coursesManagement.services.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/courses")
@CrossOrigin(origins = "http://localhost:4200")
public class CourseController {
    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private CourseService courseService;

    @GetMapping("")
    @ResponseBody
    public List<CourseDTO> getAllCourses(){return courseService.getAllCoursesDTO();}

    @RequestMapping(value = "/course/add", method = RequestMethod.POST)
    @ResponseBody()
    public Course createCourse(@Validated @RequestBody Course course){
        return courseService.createCourse(course);
    }

    @RequestMapping(value = "/course/{courseId}",method = RequestMethod.DELETE)
    @ResponseBody()
    public void deleteCourse(@Validated @RequestBody Long cId){
        courseService.deleteCourse(cId);
    }
}
