package com.skinnybonesarv;

import java.time.LocalDate;
import java.time.Period;

/**
 * Convention in Objects:
 *
 * Non-public and non-static variables' prefix -> m
 *      EX: private int mInteger;
 * Static variables' prefix -> s
 *      EX: private static int sInteger;
 *
 * Final variables -> UPPERCASE_WORDS
 *      EX: private final int INTEGER;
 * Other variables -> normal
 *      EX: public int integer;
 *
 * @author SkinnyBonesArv
 */
public abstract class Person {

    private String mLastName;
    private String mFirstName;
    private LocalDate mDateOfBirth;
    private int mID;
    private Sex mSex;

    public Person(String lastName, String firstName, LocalDate dateOfBirth, Sex sex) {
        mLastName = lastName;
        mFirstName = firstName;
        mDateOfBirth = dateOfBirth;
        mSex = sex;
    }

    // Constructor for Binary Search
    public Person(int id) {
        mID = id;
    }

    public enum Sex {
        MALE, FEMALE, OTHER
    }

    public String getLastName() {
        return mLastName;
    }

    public void setLastName(String lastName) {
        mLastName = lastName;
    }

    public String getFirstName() {
        return mFirstName;
    }

    public void setFirstName(String firstName) {
        mFirstName = firstName;
    }

    public LocalDate getDateOfBirth() {
        return mDateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        mDateOfBirth = dateOfBirth;
    }

    public int getAge() {
        return Period.between(mDateOfBirth, LocalDate.now()).getYears();
    }

    public int getID() {
        return mID;
    }

    protected void setID(int id) {
        mID = id;
    }

    public Sex getSex() {
        return mSex;
    }

    public void setSex(Sex sex) {
        mSex = sex;
    }

    protected abstract void writeToFile();

    protected String toFile() {
        return new String().format("%s, %s, %s, %s, ", getLastName(), getFirstName(), getDateOfBirth(), getSex());
    }

    @Override
    public String toString() {
        return new String().format("%-15s %-15s %-20s %-10s ", getLastName(), getFirstName(), getDateOfBirth(), getSex());
    }

}
