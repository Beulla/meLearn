package com.example.coursesManagement.controllerTests;

import com.example.coursesManagement.controllers.CourseController;
import com.example.coursesManagement.models.Course;
import com.example.coursesManagement.models.Department;
import com.example.coursesManagement.services.CourseService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.coyote.Request;
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
import java.util.Optional;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(CourseController.class)
public class CourseTests {
    @MockBean
    private CourseService courseServiceMock;

    ObjectMapper mapper=new ObjectMapper();

    @Autowired
    private MockMvc mockMvc;

    Department department=new Department(112L,"software development","all courses that tackle software development");
    Course course=new Course(002L,"software engineering","the course covers the principles and practices of software engineering","soft",department);
    @Test
   public void getAll_Success() throws Exception{

        List<Course> asList= Arrays.asList(course);
        when(courseServiceMock.getAllCourses()).thenReturn(asList);

        MockHttpServletRequestBuilder requestBuilder= MockMvcRequestBuilders
                .get("")
                .accept(MediaType.APPLICATION_JSON);

        MvcResult result=mockMvc
                .perform(requestBuilder)
                .andExpect(status().isOk())
                .andExpect(content().json("[{\"id\":2,\"name\":\"Software engineering\",\"description\":\"the course covers the principles and practices of software engineering\",\"title\":\"soft\",\"department\": 1}]"))
                .andReturn();

    }

    @Test
    public void getOne_404() throws Exception{
        when(courseServiceMock.getCourse(course.getCid())).thenReturn(Optional.ofNullable(course));
        MockHttpServletRequestBuilder requestBuilder=MockMvcRequestBuilders
                .get("/course/{course.getCid()}")
                .accept(MediaType.APPLICATION_JSON);

        MvcResult result=mockMvc
                .perform(requestBuilder)
                .andExpect(status().isNotFound())
                .andExpect(content().json("{\"status\":false,\"message\":\"Item not found\"}"))
                .andReturn();
    }

}
