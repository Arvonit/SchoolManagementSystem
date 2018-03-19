package com.test;

import java.time.LocalDate;
import java.time.Period;

public class Person {

    private String firstName;
    private String lastName;
    private LocalDate dateOfBirth;
    private int age;
    private int id;
    private Sex sex;

    /*public Person() {
        this.firstName = "";
        this.lastName = "";
        this.dateOfBirth = LocalDate.EPOCH;
        this.age = 0;
        this.id = 0;
        this.sex = Sex.OTHER;
    }*/

    public Person(String firstName, String lastName, LocalDate dateOfBirth, int id, Sex sex) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.id = id;
        this.sex = sex;
    }

    public enum Sex {
        MALE, FEMALE, OTHER
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
        age = Period.between(dateOfBirth, LocalDate.now()).getYears();
    }

    public int getAge() {
        return age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Sex getSex() {
        return sex;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }
}
