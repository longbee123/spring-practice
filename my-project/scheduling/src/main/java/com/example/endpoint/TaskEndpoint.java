package com.example.endpoint;

import com.example.task.GetTaskRequest;
import com.example.task.GetTaskResponse;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class TaskEndpoint {
    private static final String NAMESPACE_URL = "http://example.com/plus";

    @PayloadRoot(namespace = NAMESPACE_URL, localPart = "GetTaskRequest")
    @ResponsePayload
    public GetTaskResponse getTaskList(@RequestPayload GetTaskRequest getTaskRequest) {
        return null;
    }

}
