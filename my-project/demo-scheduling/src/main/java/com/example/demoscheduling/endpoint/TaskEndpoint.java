package com.example.demoscheduling.endpoint;

import com.example.demoscheduling.entity.Task;
import com.example.demoscheduling.service.TaskService;

import com.example.task.GetTaskRequest;
import com.example.task.GetTaskResponse;
import com.example.task.TaskList;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import java.util.ArrayList;
import java.util.List;

@Endpoint
public class TaskEndpoint {
    @Autowired
    private TaskService taskService;
    private static final String NAMESPACE_URL = "http://example.com/task";

    @PayloadRoot(namespace = NAMESPACE_URL, localPart = "GetTaskRequest")
    @ResponsePayload
    public GetTaskResponse getTaskList(@RequestPayload GetTaskRequest getTaskRequest) {
        return taskService.getAllTask();
    }

}
