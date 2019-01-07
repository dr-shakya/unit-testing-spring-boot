package com.LogicaBeans.LogicaEntityTest.repositories;

import com.LogicaBeans.LogicaEntityTest.model.Topic;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TopicRepository extends JpaRepository<Topic, String> {
    @Override
    Page<Topic> findAll(Pageable pageable);

    //	public Topic findByTopicId(String id);

}
