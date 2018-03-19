package com.test;

import java.util.Arrays;

public class Schedule {

    private int numOfCourses;
    private Course[] courses;

    public Schedule(int numOfCourses) {
        courses = new Course[numOfCourses];
        this.numOfCourses = numOfCourses;
    }

    public void addCourse(Course course, int period) {
        if (period <= numOfCourses) {
            courses[period] = course;
        }
    }

    public Course getCourse(int period) {
        return courses[period];
    }

    public int getPeriod(Course course) {
        return Arrays.asList(courses).indexOf(course);
    }

    public void setPeriod(Course course, int period) {
        if (courses[period] != null) {
            int oldPeriod = Arrays.asList(course).indexOf(course);
            Course oldCourse = courses[period];
            courses[period] = course;
            courses[oldPeriod] = oldCourse;
        } else if (Arrays.asList(courses).contains(course)) {
            Arrays.asList(courses).remove(course);
            courses[period] = course;
        } else {
            courses[period] = course;
        }
    }

    @Override
    public String toString() {
        return "Schedule:";
    }

}
