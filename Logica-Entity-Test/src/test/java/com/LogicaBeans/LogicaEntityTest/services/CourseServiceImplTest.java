package com.LogicaBeans.LogicaEntityTest.services;

import com.LogicaBeans.LogicaEntityTest.model.Course;
import com.LogicaBeans.LogicaEntityTest.repositories.CourseRepository;
import com.LogicaBeans.LogicaEntityTest.services.implementation.CourseServiceImpl;
import com.LogicaBeans.LogicaEntityTest.services.implementation.TopicServiceImpl;
import org.junit.*;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class CourseServiceImplTest {

    @Mock
    CourseRepository courseService;

    @Mock
    TopicServiceImpl topicServiceImpl;

    @InjectMocks
    CourseServiceImpl courseServiceImpl;

    /*@BeforeClass
    static void initialize(){

    }*/

    /*@AfterClass
    static void terminate(){
        List<Course> courses = null;
        Course course = null;
    }*/

    @Test
    public void testGetAllCourse_assert(){
        List<Course> courses = new ArrayList<>(Arrays.asList(
                new Course("spring", "Spring Boot", "Spring boot description", "java"),
                new Course("django", "Django", "Django description", "python")
        ));
        when(courseService.findByTopicId("java")).thenReturn(courses);
        Assert.assertEquals(courses, courseServiceImpl.getAllCourses("java"));
        System.out.println(courses);
    }

    @Test
    public void testAddCourses_verifySave(){
        when(courseService.save(any(Course.class))).thenReturn(new Course());
        courseServiceImpl.addCourse(new Course(), "");
        verify(courseService).save(any(Course.class));
    }

    @Test
    public void testDeleteCourse(){
        doNothing().when(courseService).deleteById("spring");
        courseServiceImpl.deleteCourse("spring");
        verify(courseService).deleteById("spring");
    }
}
