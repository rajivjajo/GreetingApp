package com.bridgelabz.greeting.model;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Greeting {
    private long id;
    private String message;

    public Greeting(long id, String message) {
        this.id = id;
        this.message = message;
    }

    public Greeting() {
    }

    @Id
    @GeneratedValue
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}