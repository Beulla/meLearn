package com.example.coursesManagement.controllers;

import com.example.coursesManagement.dto.DepartmentDTO;
import com.example.coursesManagement.models.Department;
import com.example.coursesManagement.services.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(path = "/departments")
@CrossOrigin(origins = "http://localhost:4200")
public class DepartmentController {
    @Autowired
    private DepartmentService departmentService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    @ResponseBody()
    public List<Department> getAllDepartments(){
        return departmentService.getAllDepartments();
    }

    @RequestMapping(value = "/create/new/department", method = RequestMethod.POST)
    @ResponseBody()
    public Department createDepartment(@Validated @RequestBody DepartmentDTO department){

        return departmentService.createDepartment(department);
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    @ResponseBody()
    public void deleteDepartment(@Validated @RequestBody Long dId){
        departmentService.deleteDepartment(dId);
    }
}
