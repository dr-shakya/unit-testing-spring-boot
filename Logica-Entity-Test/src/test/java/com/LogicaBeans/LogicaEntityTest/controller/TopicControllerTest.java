package com.LogicaBeans.LogicaEntityTest.controller;

import com.LogicaBeans.LogicaEntityTest.model.Topic;
import com.LogicaBeans.LogicaEntityTest.services.implementation.TopicServiceImpl;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;


@RunWith(SpringRunner.class)
//@SpringBootTest//looks for main config class and starts app context
//@AutoConfigureMockMvc//no need to start the server but app context is started
@WebMvcTest(TopicController.class) //
public class TopicControllerTest {

    @MockBean
    private TopicServiceImpl topicServiceImpl;

    @Autowired
    private MockMvc mockMvc;

    List<Topic> topics;
    Topic topic;
    String jsonMapper;

    @Before
    public void onInit(){
//        mockMvc = MockMvcBuilders.standaloneSetup(topicController).build();
        topics = new ArrayList<Topic>(Arrays.asList(
                new Topic("java", "javaEE", "java desc"),
                new Topic("python", "Django", "Django desc")
        ));
        topic = new Topic("java", "javaEE", "java desc");
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            jsonMapper = objectMapper.writeValueAsString(topic);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }

//    @Test
//    public void getAllTopics_returnStatusOk() throws Exception{
//        Mockito.when(topicServiceImpl.getAllTopics()).thenReturn(topics);
//        this.mockMvc.perform(MockMvcRequestBuilders.get("/topic"))
//                .andExpect(MockMvcResultMatchers.status().isOk())
//                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON_UTF8));
//        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/topic")).andReturn();
//        System.out.println("Content: \n" + mvcResult.getResponse().getContentAsString());
//    }

    @Test
    public void getTopic_returnStatusOk() throws Exception{
        Mockito.when(topicServiceImpl.getTopic("java")).thenReturn(topic);
        mockMvc.perform(MockMvcRequestBuilders.get("/topic/java"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON_UTF8));
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/topic/java")).andReturn();
        System.out.println("Content: \n" + mvcResult.getResponse().getContentAsString());
    }

    @Test
    public void addTopic_returnStatusOk() throws Exception{
        System.out.println("==========Json mapped:"+jsonMapper);
        mockMvc.perform(MockMvcRequestBuilders.post("/addTopic")
                .contentType(MediaType.APPLICATION_JSON_VALUE).content(jsonMapper))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void updateTopic_returnStatusOk() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.put("/topic/java")
                .contentType(MediaType.APPLICATION_JSON_VALUE).content(jsonMapper))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void deleteTopic_returnStatusOk() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.delete("/topic/java")
                .contentType(MediaType.APPLICATION_JSON_VALUE).content(jsonMapper))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

}
