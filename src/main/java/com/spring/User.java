package com.spring;

import org.springframework.stereotype.Component;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.concurrent.atomic.AtomicLong;

@Component
@Entity
public class User {
    private String firstName="";
    private String lastName="";

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    public User(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public User() { }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setId(Long id) {

        this.id = id;
    }


    @Override
    public String toString() {
    return (firstName+lastName).equals("")? "World" : firstName+" "+lastName;
    }

}
