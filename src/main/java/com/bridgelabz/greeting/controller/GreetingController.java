package com.bridgelabz.greeting.controller;
import com.bridgelabz.greeting.model.Greeting;
import com.bridgelabz.greeting.service.GreetingService;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/greetings")
public class GreetingController {
    @Autowired
    public GreetingService service;

    @GetMapping()
    public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name){
        return service.greeting(name);
    }
    @RequestMapping("/welcome")
    public String displayMessage(){
        return service.greetingMessage();
    }
    @RequestMapping("/greetBy")
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
    @PutMapping("/editGreeting/{id}")
    public Greeting editGreeting(@RequestBody Greeting greeting, @PathVariable Integer id){
        return service.editGreeting(greeting, id);
    }
    @DeleteMapping("/deleteGreeting/{id}")
    public void deleteReading(@PathVariable Integer id){
        service.deleteGreeting(id);
    }
}