package com.LogicaBeans.LogicaEntityTest.services;

import com.LogicaBeans.LogicaEntityTest.model.Topic;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface TopicService {
    public Page<Topic> getAllTopics(Pageable pageable);

    public Topic getTopic(String id);

    public void addTopic(Topic topic);

    public void updateTopic(Topic topic, String id);

    public void deleteTopic(String id);
}
