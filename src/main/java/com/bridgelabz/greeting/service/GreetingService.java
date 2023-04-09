package com.bridgelabz.greeting.service;

import com.bridgelabz.greeting.model.Greeting;
import com.bridgelabz.greeting.repository.GreetingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GreetingService {
    @Autowired
    public GreetingRepository repository;
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

    public Greeting saveGreeting(Greeting greeting) {
        return repository.save(greeting);
    }

    public Greeting getGreetingById(Integer id) {
        return repository.findById(id).orElse(null);
    }

    public List<Greeting> getGreetings() {
        return repository.findAll();
    }
}