package com.skinnybonesarv.beta;

import java.time.LocalDate;

public class Student extends Person {

    private int grade;
    private Schedule schedule;

    public Student(String firstName, String lastName, LocalDate dateOfBirth, int id, Sex sex, int grade,
                   Schedule schedule) {
        super(firstName, lastName, dateOfBirth, id, sex);
        this.grade = grade;
        this.schedule = schedule;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public Schedule getSchedule() {
        return schedule;
    }

}
