package com.example.coursesManagement.services;

import com.example.coursesManagement.dto.DepartmentDTO;
import com.example.coursesManagement.models.Department;
import com.example.coursesManagement.repositories.CourseRepository;
import com.example.coursesManagement.repositories.DepartmentRepository;
import com.example.coursesManagement.repositories.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class DepartmentService {
    @Autowired
    DepartmentRepository departmentRepository;

    @Autowired
    CourseRepository courseRepository;

    @Autowired
    TeacherRepository teacherRepository;

    public List<Department> departments=new ArrayList<>();
    public List<Department> getAllDepartments(){
        departments.clear();
        departmentRepository.findAll().forEach(department -> {
            departments.add(department);
        });
        return departments;
    }
    public Set<Department> getAllDepartmentDetails(){
        Set<Department> departments1=new HashSet<>();
        departmentRepository.findAll().forEach(department -> {
            Department retrievedDepartment=new Department();
            retrievedDepartment.setName(department.getName());
            retrievedDepartment.setDid(department.getDid());
            retrievedDepartment.setDescription(department.getDescription());
            retrievedDepartment.setCourses(department.getCourses());
            departments1.add(department);
        });
        return departments1;
    }
    public Department getDepartment(String departmentId){
        Long did=Long.parseLong(departmentId);
        Department department= (Department) departmentRepository.findAllById(Collections.singleton(did));
        return department;
    }
    public Department createDepartment(DepartmentDTO departmentDTO){
        Set li=new HashSet<>();
        Department department=new Department(departmentDTO.getName(),departmentDTO.getDescription(),li,li,li);
        return  departmentRepository.save(department);
    }
    public void deleteDepartment(Long did){
        departmentRepository.deleteById(did);
    }
}
