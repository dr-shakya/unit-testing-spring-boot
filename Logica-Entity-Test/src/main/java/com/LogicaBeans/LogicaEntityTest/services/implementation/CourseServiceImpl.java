package com.LogicaBeans.LogicaEntityTest.services.implementation;

import java.util.List;

import com.LogicaBeans.LogicaEntityTest.model.Course;
import com.LogicaBeans.LogicaEntityTest.exception.ResourceNotFoundException;
import com.LogicaBeans.LogicaEntityTest.repositories.CourseRepository;
import com.LogicaBeans.LogicaEntityTest.services.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.LogicaBeans.LogicaEntityTest.model.Topic;

@Service
public class CourseServiceImpl implements CourseService {

	@Autowired
	private CourseRepository courseService;
	
	@Autowired
	private TopicServiceImpl topicServiceImpl;
	
	public List<Course> getAllCourses(String topicId){
		List<Course> courses = courseService.findByTopicId(topicId);
		return courses;
	}

	public Course getCourse(String id) {
		return courseService.findById(id).orElseThrow(() -> new ResourceNotFoundException("Course not found"));

	}
	
	public void addCourse(Course course,String topicId) {
		Topic topic= topicServiceImpl.getTopic(topicId);
		course.setTopic(topic);
		courseService.save(course);
	}
	
	public void updateCourse(Course course, String topicId) {
		Topic topic= topicServiceImpl.getTopic(topicId);
		course.setTopic(topic);
		courseService.save(course);
	}
	
	public void deleteCourse(String id) {
		courseService.deleteById(id);
	}
}
