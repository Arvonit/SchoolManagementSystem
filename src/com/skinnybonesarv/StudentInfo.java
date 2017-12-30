package com.skinnybonesarv;

public class StudentInfo {
    // Declarations
    private String firstName;
    private String lastName;
    private String sex;
    private int yearBorn;
    private int monthBorn;
    private int dayBorn;

    public StudentInfo(String firstName, String lastName, String sex, int yearBorn, int monthBorn, int dayBorn, int ID) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.sex = sex;
        this.yearBorn = yearBorn;
        this.monthBorn = monthBorn;
        this.dayBorn = dayBorn;
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
}
