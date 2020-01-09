package com.spring.service;

import com.spring.Greeting;
import com.spring.User;

import java.util.List;

public interface IGreetingService {

    Greeting addGreeting(User user);
    Greeting getGreetingById(long id);
    public List<Greeting> getAllGreeting();
    void UpdateById(long id, String firstName, String lastName);
    void deleteGreetingById(long id);

}
