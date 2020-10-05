package com.example.soapdemo;


import com.example.plus.GetPlusRequest;
import com.example.plus.GetPlusResponse;
import com.example.plus.Result;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class PlusEndpoint {
    private static final String NAMESPACE_URI = "http://example.com/plus";

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "GetPlusRequest")
    @ResponsePayload
    public GetPlusResponse processCourseDetailsRequest(@RequestPayload GetPlusRequest request) {
        GetPlusResponse response = new GetPlusResponse();
        Result result = new Result();
        result.setResult(request.getX() + request.getY());
        response.setResult(result);
        return response;
    }
}
