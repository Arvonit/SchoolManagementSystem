package com.test;

/**
 * Finish implementing toString method.
 */

public class Course {

    private int numOfCredits;
    private String name;
    private CourseType courseType;

    public Course(int numOfCredits, String name, CourseType courseType) {
        this.numOfCredits = numOfCredits;
        this.name = name;
        this.courseType = courseType;
    }

    public enum CourseType {
        MATH, SCIENCE, ENGLISH, HISTORY, FOREEIGN_LANGUAGE, ARTS
    }

    public int getNumOfCredits() {
        return numOfCredits;
    }

    public void setNumOfCredits(int numOfCredits) {
        this.numOfCredits = numOfCredits;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CourseType getCourseType() {
        return courseType;
    }

    public void setCourseType(CourseType courseType) {
        this.courseType = courseType;
    }

    @Override
    public String toString() {
        return "Course:";
    }

}
