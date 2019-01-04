package com.LogicaBeans.LogicaEntityTest.repositories;

import com.LogicaBeans.LogicaEntityTest.model.Topic;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TopicRepository extends JpaRepository<Topic, String> {

//	public Topic findByTopicId(String id);

}
