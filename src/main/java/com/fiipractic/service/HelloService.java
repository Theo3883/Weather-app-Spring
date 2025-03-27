package com.fiipractic.service;

import org.springframework.stereotype.Service;

@Service
public class HelloService {

    public String getGreeting() {
        return "Hello from FII Practic!";
    }
}

