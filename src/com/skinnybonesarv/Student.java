/**
 * @author SkinnyBonesArv
 * @version 1/15/2018
 */

package com.skinnybonesarv;

public class Student {
    // Declarations
    private String firstName;
    private String lastName;
    private String sex;
    private int grade;
    private int yearBorn;
    private int monthBorn;
    private int dayBorn;
    private int id;

    public Student(String firstName, String lastName, String sex, int grade, int monthBorn, int dayBorn, int yearBorn, int id) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.sex = sex;
        this.grade = grade;
        this.monthBorn = monthBorn;
        this.dayBorn = dayBorn;
        this.yearBorn = yearBorn;
        this.id = id;
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

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public int getYearBorn() {
        return yearBorn;
    }

    public void setYearBorn(int yearBorn) {
        this.yearBorn = yearBorn;
    }

    public int getMonthBorn() {
        return monthBorn;
    }

    public void setMonthBorn(int monthBorn) {
        this.monthBorn = monthBorn;
    }

    public int getDayBorn() {
        return dayBorn;
    }

    public void setDayBorn(int dayBorn) {
        this.dayBorn = dayBorn;
    }

    public int getID() {
        return id;
    }

    public void setID(int id) {
        this.id = id;
    }
}
