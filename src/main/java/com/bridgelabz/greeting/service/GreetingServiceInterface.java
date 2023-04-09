package com.bridgelabz.greeting.service;


import com.bridgelabz.greeting.model.Greeting;
import com.bridgelabz.greeting.model.User;

import java.util.List;

public interface GreetingServiceInterface {
    Greeting saveGreeting(Greeting greeting);
    Greeting getGreetingById(Integer id);
    List<Greeting> getGreetings();
    Greeting editGreeting(Greeting greeting, Integer id);
    void deleteGreeting(Integer id);
}