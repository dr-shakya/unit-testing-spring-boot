package com.LogicaBeans.LogicaEntityTest.controller;

import java.util.List;

import com.LogicaBeans.LogicaEntityTest.model.Topic;
import com.LogicaBeans.LogicaEntityTest.services.implementation.TopicServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class TopicController {

	@Autowired
	private TopicServiceImpl topicServiceImpl;
	
	@GetMapping("/topic")
	public List<Topic> getAllTopics(){
		return topicServiceImpl.getAllTopics();
	}
	
	@GetMapping("/topic/{id}")
	public Topic getTopic(@PathVariable String id) {
		return topicServiceImpl.getTopic(id);
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/addTopic")
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