package com.LogicaBeans.LogicaEntityTest.services;

import com.LogicaBeans.LogicaEntityTest.model.Topic;

import java.util.List;

public interface TopicService {
    public List<Topic> getAllTopics();

    public Topic getTopic(String id);

    public void addTopic(Topic topic);

    public void updateTopic(Topic topic, String id);

    public void deleteTopic(String id);
}
