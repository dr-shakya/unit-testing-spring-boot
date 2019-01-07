package com.LogicaBeans.LogicaEntityTest.controller;


import java.util.List;

import com.LogicaBeans.LogicaEntityTest.model.Topic;
import com.LogicaBeans.LogicaEntityTest.services.implementation.TopicServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

@RestController
public class TopicController {

	@Autowired
	private TopicServiceImpl topicServiceImpl;
	
	@GetMapping("/topic")
	public Page<Topic> getAllTopics (@PageableDefault(page = 0,size = 10) Pageable pageable){
		return topicServiceImpl.getAllTopics(pageable);
	}
	
	@GetMapping("/topic/{id}")
	public Topic getTopic(@PathVariable String id) {
		return topicServiceImpl.getTopic(id);
	}
	
	@PostMapping(value="/addTopic")
	public void addTopic(@RequestBody Topic topic) {
		topicServiceImpl.addTopic(topic);
	}

	@PutMapping(value="/topic/{id}")
	public void updateTopic(@RequestBody Topic topic, @PathVariable String id) {
		topicServiceImpl.updateTopic(topic, id);
	}

	@DeleteMapping(value="/topic/{id}")
	public void deleteTopic(@PathVariable String id) {
		topicServiceImpl.deleteTopic(id);
	}
}