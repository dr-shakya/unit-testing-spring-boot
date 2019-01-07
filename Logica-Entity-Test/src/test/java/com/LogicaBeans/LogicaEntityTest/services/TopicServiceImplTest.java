package com.LogicaBeans.LogicaEntityTest.services;

import com.LogicaBeans.LogicaEntityTest.model.Topic;
import com.LogicaBeans.LogicaEntityTest.exception.ResourceNotFoundException;
import com.LogicaBeans.LogicaEntityTest.repositories.TopicRepository;
import com.LogicaBeans.LogicaEntityTest.services.implementation.TopicServiceImpl;
import org.junit.*;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class TopicServiceImplTest {

    @Mock
    private TopicRepository topicRepository;

    @InjectMocks
    private TopicServiceImpl topicServiceImpl;

    @Rule
    public ExpectedException exceptionRule = ExpectedException.none();

    List<Topic> topics;
    Topic topic;

    @Before
    public void onInit(){
        topics = new ArrayList<>(Arrays.asList(
                new Topic("java", "JavaEE", "JavaEE description"),
                new Topic("python", "Django", "Django description")
        ));
    }

    @After
    public void onTerminate(){
        topics = null;
    }

    //get all topics
//    @Test
//    public void getAllTopicsTest_assertValues(){
//        when(topicRepository.findAll()).thenReturn(topics);
////        when(topicRepository.findAll()).thenReturn(Arrays.asList(topic));
//        Assert.assertEquals(topics, topicServiceImpl.getAllTopics());
//    }


    //add topic
    // TEST OF VOID METHODS //
    @Test
    public void testAddTopic_verifySave(){
        Logger logger = LoggerFactory.getLogger(TopicServiceImplTest.class);
        logger.debug("");
        System.out.println(logger);
//        Topic topic = new Topic("id", "php", "php description");

        //call save method
        when(topicRepository.save(any(Topic.class))).thenReturn(new Topic());
        topicServiceImpl.addTopic(new Topic());

        // USING VERIFY
        //check if save is called
        verify(topicRepository).save(any(Topic.class)); //verify(mock).function()
        //check if add is called once
//        verify(topicServiceImpl, times(1)).addTopic(topic);

//        Topic topic1 = new Topic("id", "php", "php description");
//        doNothing().when(topicRepository).save(topic1);
//        topicServiceImpl.addTopic(topic1);
    }

    //update topic
    @Test
    public void testUpdateTopic_verifySave(){
        Topic topic = new Topic("id", "php", "php description");
        when(topicRepository.save(topic)).thenReturn(topic);
        topicServiceImpl.updateTopic(topic, "id");
        verify(topicRepository).save(topic);

    }

    //get topic
    @Test//(expected = ResourceNotFoundException.class)
    public void getTopicTest_verifyFindById(){
        Topic topic = new Topic("id", "php", "php description");
        when(topicRepository.findById("id")).thenReturn(Optional.of(topic));
        topicServiceImpl.getTopic("id");
        verify(topicRepository).findById("id");
    }

    //using expected of @Test
    @Test(expected = ResourceNotFoundException.class)
    public void getTopic_expectTopicNotFound(){
        when(topicRepository.findById("something")).thenReturn(Optional.empty());
        topicServiceImpl.getTopic("something");
    }

    //using ExpectedException
    @Test
    public void getTopic_expectedException(){
        exceptionRule.expect(ResourceNotFoundException.class);
        when(topicRepository.findById("something")).thenReturn(Optional.empty());
        topicServiceImpl.getTopic("something");
    }



    //delete topic
    @Test
    public void deleteTopicTest_verifyDeleteById(){
        doNothing().when(topicRepository).deleteById("id");
        topicServiceImpl.deleteTopic("id");
        verify(topicRepository).deleteById("id");

//        when(topicRepository.delete(topic)).thenReturn(true);
    }
}
