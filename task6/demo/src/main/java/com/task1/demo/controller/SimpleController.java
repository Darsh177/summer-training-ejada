package com.task1.demo.controller;

import com.task1.demo.service.SimpleService;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.boot.autoconfigure.task.TaskExecutionProperties;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SimpleController {
    private final SimpleService simpleService;

    public SimpleController(SimpleService simpleService) {
        this.simpleService = simpleService;
    }

    @GetMapping("/test")
    public String handleRequest(HttpServletRequest request){
        String method = request.getMethod();
        String clientIp = request.getRemoteAddr();

        return simpleService.getMessage() + "\nhttp method : "+ method + "  client ip : " + clientIp;
    }
}
