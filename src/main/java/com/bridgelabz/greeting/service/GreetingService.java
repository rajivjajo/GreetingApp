package com.bridgelabz.greeting.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GreetingService {
    public String greetingMessage(){
        return "Hello World!";
    }
}