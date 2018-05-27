package com.skinnybonesarv;

public class Person {
    private String firstName;
    public String lastName;
    public String sex;
    public int yearBorn;
    public int monthBorn;
    public int dayBorn;
    public int ID;

    public Person(String firstName, String lastName, String sex, int yearBorn, int monthBorn, int dayBorn, int ID) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.sex = sex;
        this.yearBorn = yearBorn;
        this.monthBorn = monthBorn;
        this.dayBorn = dayBorn;
        this.ID = ID;
    }
}
