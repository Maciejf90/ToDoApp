package com.example.demo.controllers;

import com.example.demo.services.TaskService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.ui.Model;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.anySet;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

/**
 * Created by filutma1 on 2017-11-14.
 */
public class IndexControllerTest {

    @Mock
    TaskService taskService;

    @Mock
    Model model;

    IndexController indexController;


    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        indexController = new IndexController(taskService);
    }

    @Test
    public void testGetIndexPage() throws Exception {

    String viewName = indexController.getIndexPage(model);

    assertEquals("index", viewName);
    verify(taskService, times(1)).getAllTasks();
    verify(model, times(1)).addAttribute(eq("tasks"),anySet());
    }
}