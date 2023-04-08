package com.bridgelabz.greeting.model;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class User {

    private Integer id;

    public void setId(Integer id) {
        this.id = id;
    }

    @Id
    @GeneratedValue
    public Integer getId() {
        return id;
    }
}