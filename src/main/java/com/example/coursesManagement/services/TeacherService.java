package com.example.coursesManagement.services;

import com.example.coursesManagement.dto.CourseDTO;
import com.example.coursesManagement.dto.TeacherDTO;
import com.example.coursesManagement.models.Teacher;
import com.example.coursesManagement.repositories.DepartmentRepository;
import com.example.coursesManagement.repositories.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class TeacherService {
    @Autowired
    TeacherRepository teacherRepository;

    @Autowired
    DepartmentRepository departmentRepository;

    public Iterable<Teacher> getAllTeachers(){
        return teacherRepository.findAll();
    }
    public Optional<Teacher> getTeacher(Long teacherId){
        return teacherRepository.findById(teacherId);
    }
    public Teacher createTeacher(TeacherDTO teacherDTO){
        Teacher teacher=new Teacher();
        teacher.setName(teacherDTO.getName());
        teacher.setEmail(teacherDTO.getEmail());
        return teacherRepository.save(teacher);
    }
    public void deleteTeacher(Long tId){
        teacherRepository.deleteById(tId);
    }
    public List<CourseDTO> getCoursesForTeacher(Long id){
        Teacher teacher= (Teacher) teacherRepository.findAllById(Collections.singleton(id));
        List<CourseDTO> courseDTOS=new ArrayList<>();
        teacher.getCourses().forEach(course -> {
            CourseDTO courseDTO=new CourseDTO();
            courseDTO.setName(course.getName());
            courseDTO.setDescription(course.getDescription());
            courseDTO.setTitle(course.getTitle());
            courseDTO.setCid(course.getCid());
            courseDTOS.add(courseDTO);
        });
        return courseDTOS;
    }
}
