package com.spring.service;

import com.spring.model.Greeting;
import com.spring.model.User;
import com.spring.repository.GreetingRepository;
import com.spring.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GreetingService implements IGreetingService {
    private static final String template = "Hello, %s !";

    public GreetingService() {
    }

    @Autowired
    private GreetingRepository greetingRepository;
    @Autowired
    private UserRepository userRepository;

    @Override
    public Greeting addGreeting(User user) {
        String message = String.format(template, (user.toString().isEmpty()) ? "Hello World" : user.toString());
        userRepository.save(user);
        return greetingRepository.save(new Greeting(message, user.getId()));
    }

    @Override
    public Greeting getGreetingById(long id) {
        return greetingRepository.findById(id).get();
    }

    @Override
    public List<Greeting> getAllGreeting() {
        return greetingRepository.findAll();
    }

    @Override
    public void UpdateById(long id, String firstName, String lastName) {
        Greeting greeting = greetingRepository.findById(id).get();
        greeting.setName(firstName + lastName);
        greetingRepository.save(greeting);
    }

    @Override
    public void deleteGreetingById(long id) {
        greetingRepository.deleteById(id);
    }

}