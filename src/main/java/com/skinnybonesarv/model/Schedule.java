package com.skinnybonesarv.model;

import java.util.Arrays;

/**
 * TODO: Finish implementing toString method.
 * WARNING: Not fully developed yet.
 *
 * @author SkinnyBonesArv
 */
public class Schedule {

    private int mNumOfCourses;
    private Course[] mCourses;

    public Schedule(int numOfCourses) {
        mCourses = new Course[numOfCourses];
        mNumOfCourses = numOfCourses;
    }

    public void addCourse(Course course, int period) {
        try {
            mCourses[period] = course;
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Error: Already enough courses in schedule.");
            e.printStackTrace();
        }
    }

    public Course getCourse(int period) {
        return mCourses[period];
    }

    public int getPeriod(Course course) {
        return Arrays.asList(mCourses).indexOf(course); // Doesn't work
    }

    public void setPeriod(Course course, int period) {
        if (mCourses[period] != null) {
            int oldPeriod = Arrays.asList(course).indexOf(course); // Might not work
            Course oldCourse = mCourses[period];
            mCourses[period] = course;
            mCourses[oldPeriod] = oldCourse;
        } else if (Arrays.asList(mCourses).contains(course)) {
            Arrays.asList(mCourses).remove(course);
            mCourses[period] = course;
        } else {
            mCourses[period] = course;
        }
    }

    @Override
    public String toString() {
        return String.format("Schedule - Number of Courses: %d", mNumOfCourses);
    }

}
