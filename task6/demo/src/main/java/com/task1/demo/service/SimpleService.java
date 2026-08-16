package com.task1.demo.service;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.stereotype.Service;

@Service
public class SimpleService {

    public SimpleService(){
        System.out.println("\nservice intanse is created");
    }

    @PostConstruct
    public void init(){
        System.out.println("\ninitialization task is done");
    }

    public String getMessage() {
        return "\nHello from Spring Container & Dependency Injection!\n";
    }

    @PreDestroy
    public void destroy(){
        System.out.println("\nservice is destroy");
    }
}
