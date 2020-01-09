package com.spring.service;

import com.spring.Greeting;
import com.spring.User;
import com.spring.repository.GreetingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class GreetingService implements IGreetingService {
    private  static final  String template =  "Hello, %s !";
//    private  final AtomicLong counter = new AtomicLong();

    public GreetingService() { }

    @Autowired
    private GreetingRepository greetingRepository;

    @Override
    public Greeting addGreeting(User user) {
        String message = String.format(template, (user.toString().isEmpty()) ? "Hello World" : user.toString());
        return greetingRepository.save(new Greeting(message) ) ;
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
        Greeting greeting =greetingRepository.findById(id).get();
        greeting.setName(firstName+lastName);
        greetingRepository.save(greeting);
    }

    @Override
    public void deleteGreetingById(long id) {
        greetingRepository.deleteById(id);
    }

}