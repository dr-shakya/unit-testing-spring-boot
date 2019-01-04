package com.LogicaBeans.LogicaEntityTest.repositories;

import java.util.List;

import com.LogicaBeans.LogicaEntityTest.model.Course;
import org.springframework.data.repository.CrudRepository;

public interface CourseRepository extends CrudRepository<Course, String> {
	
	public List<Course> findByTopicId(String topicId);

}
