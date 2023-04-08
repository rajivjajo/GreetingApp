package com.bridgelabz.greeting.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GreetingService {
    public String greetingMessage(){
        return "Hello World!";
    }

    public String greetWithName(String firstName, String lastName) {
        if(firstName.isEmpty() && lastName.isEmpty())
            return greetingMessage();
        else if (firstName!="" && lastName=="") {
            return "Hello "+firstName;
        }
        else if (lastName!="" && firstName=="") {
            return "Hello "+lastName;
        }
        else
            return "Hello, "+firstName+" "+lastName+"!";
    }
}