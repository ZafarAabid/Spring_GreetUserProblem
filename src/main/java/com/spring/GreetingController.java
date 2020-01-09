package com.spring;

import com.spring.model.Greeting;
import com.spring.model.User;
import com.spring.service.IGreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/greeting")
public class GreetingController {

    private static final String template = "Hello, %s!";
//    private final AtomicLong counter = new AtomicLong();

    @Autowired
    private IGreetingService greetingService;

    @GetMapping("/addByParameter")
    public Greeting addGreeting(@RequestParam(value = "firstName", defaultValue = "") String firstName, @RequestParam(value = "lastName", defaultValue = "") String lastName) {
        User user = new User();
        user.setFirstName(firstName);
        user.setLastName(lastName);
        return greetingService.addGreeting(user);
    }

//    curl -X POST -H "Content-Type: application/json" -d '{"firstName" : "kumud","lastName" : "Garg"}' "http://localhost:8080/greeting/gr/" -w "\n"
    @PostMapping("/addByBody/")
    public Greeting addGreetingByUserPojo(@RequestBody User user) {
        return greetingService.addGreeting(user);
    }

    @GetMapping("/get/{id}")
    public Greeting getGreeting(@PathVariable long id) {
        return greetingService.getGreetingById(id);
    }

    @GetMapping("/getAll")
    public List<Greeting> getGreeting() {
        return greetingService.getAllGreeting();
    }

    //curl -X PUT "http://localhost:8080/greeting/update/id/?firstName=Akshay&lastName=Patwari"
    @PutMapping("/update/{id}/")
    public void updateGreeting(@PathVariable(value = "id") long id, @RequestParam(value = "firstName") String firstName, @RequestParam(value = "lastName") String lastName) {
        greetingService.UpdateById(id, firstName, lastName);
    }


    @DeleteMapping("delete/{id}")
    public void deleteGreeting(@PathVariable long id) {
        greetingService.deleteGreetingById(id);
    }

}