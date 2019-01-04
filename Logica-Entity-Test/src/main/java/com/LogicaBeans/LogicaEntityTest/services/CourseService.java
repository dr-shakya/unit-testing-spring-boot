package com.LogicaBeans.LogicaEntityTest.services;

import com.LogicaBeans.LogicaEntityTest.model.Course;

import java.util.List;

public interface CourseService {
    public List<Course> getAllCourses(String topicId);

    public Course getCourse(String id);

    public void addCourse(Course course,String topicId);

    public void updateCourse(Course course, String topicId);

    public void deleteCourse(String id);
}
