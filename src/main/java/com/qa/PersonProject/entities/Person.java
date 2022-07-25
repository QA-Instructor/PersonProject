package com.qa.PersonProject.entities;

import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Person {

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Person(@Size(min = 2, max = 30) @NotNull String firstname, @Size(min = 2, max = 30) String lastname, @Min(18) @Max(75) int age) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.age = age;
    }

    public Person(){
        this.firstname = "Unknown firstname";
        this.lastname = "Unknown lastname";
        this.age = 18;
    }

    @Size(min=2, max=30)
    @NotNull
    private String firstname;

    @Size(min=2, max=30)
    private String lastname;

    @Min(18)
    @Max(75)
    private int age;
}


