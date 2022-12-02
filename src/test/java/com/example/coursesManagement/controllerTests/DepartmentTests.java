package com.example.coursesManagement.controllerTests;

import com.example.coursesManagement.controllers.CourseController;
import com.example.coursesManagement.models.Course;
import com.example.coursesManagement.models.Department;
import com.example.coursesManagement.services.CourseService;
import com.example.coursesManagement.services.DepartmentService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(CourseController.class)
public class DepartmentTests {
    @MockBean
    private DepartmentService departmentServiceMock;

    ObjectMapper mapper=new ObjectMapper();

    @Autowired
    private MockMvc mockMvc;

    Department department=new Department(112L,"software development","all courses that tackle software development");
    @Test
    public void getAll_Success() throws Exception{

        List<Department> asList= Arrays.asList(department);
        when(departmentServiceMock.getAllDepartments()).thenReturn(asList);

        MockHttpServletRequestBuilder requestBuilder= MockMvcRequestBuilders
                .get("")
                .accept(MediaType.APPLICATION_JSON);

        MvcResult result=mockMvc
                .perform(requestBuilder)
                .andExpect(status().isOk())
                .andExpect(content().json("[{\"id\":2,\"name\":\"software development\",\"description\":\"all courses that tackle software development\"}]"))
                .andReturn();

    }

    @Test
    public void deleteSuccess() throws Exception{
        when(departmentServiceMock.getDepartment(String.valueOf(department.getDid()))).thenReturn(department);
        MockHttpServletRequestBuilder requestBuilder=MockMvcRequestBuilders

                .get("/delete/{department.getDid()}")
                .accept(MediaType.APPLICATION_JSON);

        MvcResult result=mockMvc
                .perform(requestBuilder)
                .andExpect(status().isNotFound())
                .andExpect(content().json("{\"status\":false,\"message\":\"Item not found\"}"))
                .andReturn();
    }

}
