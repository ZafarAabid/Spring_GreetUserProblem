package com.spring.model;

import javax.persistence.*;

@Entity
public class Greeting {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private long id;
    private String name;
    private long userId;

    public Greeting() {}

    public Greeting(String message,long userId) {
        this.name = message;
        this.userId = userId;
    }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
}