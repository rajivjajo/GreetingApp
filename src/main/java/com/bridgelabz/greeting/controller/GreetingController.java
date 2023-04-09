package com.bridgelabz.greeting.controller;
import com.bridgelabz.greeting.model.Greeting;
import com.bridgelabz.greeting.service.GreetingService;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

@RestController
public class GreetingController {
    public static final String template = "Hello, %s!";
    public final AtomicInteger counter = new AtomicInteger();
    @Autowired
    public GreetingService service;

    @GetMapping("/greeting")
    public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name){
        return new Greeting(counter.incrementAndGet(), String.format(template, name));
    }
    @RequestMapping("/welcome")
    public String displayMessage(){
        return service.greetingMessage();
    }
    @RequestMapping("/greetings")
    public String greetWithName(@RequestParam(value = "firstName", defaultValue = "") String firstName,
                                @RequestParam(value = "lastName", defaultValue = "") String lastName){
        return service.greetWithName(firstName, lastName);
    }
    @PostMapping("/addGreeting")
    public Greeting addGreeting(@RequestBody Greeting greeting){
        return service.saveGreeting(greeting);
    }
    @GetMapping("/greetingById/{id}")
    public Greeting displayGreetingById(@PathVariable Integer id){
        return service.getGreetingById(id);
    }
    @GetMapping("/allGreetings")
    public List<Greeting> getAllGreetings() {
        return service.getGreetings();
    }
}