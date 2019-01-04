package com.LogicaBeans.LogicaEntityTest.controller;

import java.util.List;

import com.LogicaBeans.LogicaEntityTest.model.Course;
import com.LogicaBeans.LogicaEntityTest.services.implementation.CourseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class CourseController {
	
	@Autowired
	private CourseServiceImpl courseServiceImpl;
	
	@RequestMapping(value = "topic/{id}/course")
	public List<Course> getAllCourses(@PathVariable String id){
		return courseServiceImpl.getAllCourses(id);
	}
	
	@RequestMapping(value = "/topic/{topicId}/course/{id}")
	public Course getCourse(@PathVariable String id) {
		return courseServiceImpl.getCourse(id);
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/topic/{topicId}/course/")
	public void addCourse(@RequestBody Course course, @PathVariable String topicId) {
		courseServiceImpl.addCourse(course,topicId);
	}


	@PutMapping(value="/topic/{topicId}/course/{id}")
//	@RequestMapping(method=RequestMethod.POST, value="/topic/{topicId}/course/{id}")
	public void updateCourse(@RequestBody Course course, @PathVariable String topicId, @PathVariable String id) {
		courseServiceImpl.updateCourse(course, topicId);
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/topic/{topicId}/course/{id}")
	public void deleteCourse(@PathVariable String id) {
		courseServiceImpl.deleteCourse(id);
	}
}