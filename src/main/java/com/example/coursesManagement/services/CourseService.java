package com.example.coursesManagement.services;

import com.example.coursesManagement.dto.CourseDTO;
import com.example.coursesManagement.models.Course;
import com.example.coursesManagement.repositories.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CourseService {
    @Autowired
    CourseRepository courseRepo;

    private List<Course> courses=new ArrayList<>();
    private List<CourseDTO> courseDTO=new ArrayList<>();

    public List<Course> getAllCourses(){
        courses.clear();
        courseRepo.findAll().forEach(course -> {
            courses.add(course);
        });
        System.out.print(courses);
        return courses;
    }
    public List<CourseDTO> getAllCoursesDTO(){
        courseDTO.clear();
        courseRepo.findAll().forEach(course -> {
            CourseDTO c=new CourseDTO();
            c.setCid(course.getCid());
            c.setTitle(course.getTitle());
            c.setDescription(course.getDescription());
            c.setName(course.getName());
            courseDTO.add(c);
        });
        return courseDTO;
    }

    public Optional<Course> getCourse(Long courseID){

        return courseRepo.findById(courseID);
    }
    public Course createCourse(Course course){
        return courseRepo.save(course);
    }
    public void deleteCourse(@Validated @RequestBody Long cId){
        courseRepo.deleteById(cId);
    }


}
