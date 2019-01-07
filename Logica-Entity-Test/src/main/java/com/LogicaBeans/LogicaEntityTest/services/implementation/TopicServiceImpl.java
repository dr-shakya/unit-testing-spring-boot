package com.LogicaBeans.LogicaEntityTest.services.implementation;

import java.util.List;

import com.LogicaBeans.LogicaEntityTest.model.Topic;
import com.LogicaBeans.LogicaEntityTest.exception.ResourceNotFoundException;
import com.LogicaBeans.LogicaEntityTest.repositories.TopicRepository;
import com.LogicaBeans.LogicaEntityTest.services.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class TopicServiceImpl implements TopicService {

	@Autowired
	private TopicRepository topicRepository;
	
	public Page<Topic> getAllTopics(Pageable pageable){
		Page<Topic> topics = topicRepository.findAll(pageable);
		return topics;
	}

	public Topic getTopic(String id) {
		return topicRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Topic not available"));
//		Optional<Topic> topic = topicRepository.findById(id);
//		if (!topic.isPresent()){
//			throw new ResourceNotFoundException("Topic: " + id + " not available");
//		}
//		return topic.get();
	}
	
	public void addTopic(Topic topic) {
		topicRepository.save(topic);
	}
	
	public void updateTopic(Topic topic, String id) {
		topicRepository.save(topic);
	}
	
	public void deleteTopic(String id) {
		topicRepository.deleteById(id);
	}
}
