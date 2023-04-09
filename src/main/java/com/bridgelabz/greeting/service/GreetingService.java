package com.bridgelabz.greeting.service;

import com.bridgelabz.greeting.model.Greeting;
import com.bridgelabz.greeting.repository.GreetingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class GreetingService implements GreetingServiceInterface {
    public static final String template = "Hello, %s!";
    public final AtomicInteger counter = new AtomicInteger();
    @Autowired
    public GreetingRepository repository;
    public Greeting greeting(String name) {
        return new Greeting(counter.incrementAndGet(), String.format(template, name));
    }
    public String greetingMessage(){
        return "Hello World!";
    }
    public String greetWithName(String firstName, String lastName) {
        if(firstName.isEmpty() && lastName.isEmpty())
            return greetingMessage();
        else if (firstName!="" && lastName=="") {
            return String.format(template, firstName);
        }
        else if (lastName!="" && firstName=="") {
            return String.format(template, lastName);
        }
        else {
            String fullName = firstName+" "+lastName;
            return String.format(template, fullName);
        }
    }
    @Override
    public Greeting saveGreeting(Greeting greeting) {
        return repository.save(greeting);
    }
    @Override
    public Greeting getGreetingById(Integer id) {
        return repository.findById(id).orElse(null);
    }
    @Override
    public List<Greeting> getGreetings() {
        return repository.findAll();
    }
    @Override
    public Greeting editGreeting(Greeting greeting, Integer id) {
        Greeting existingGreet = repository.findById(id).orElse(null);
        if (existingGreet != null) {
            existingGreet.setMessage(greeting.getMessage());
            return repository.save(existingGreet);
        }else return null;
    }
    @Override
    public void deleteGreeting(Integer id) {
        repository.deleteById(id);
    }
}