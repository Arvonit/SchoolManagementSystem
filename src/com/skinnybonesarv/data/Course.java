package com.skinnybonesarv.data;

/**
 * TODO: Finish implementing toString method.
 * WARNING: Not fully developed yet.
 *
 * @author SkinnyBonesArv
 */
public class Course {

    private int mNumOfCredits;
    private String mName;
    private CourseType mCourseType;

    public Course(int numOfCredits, String name, CourseType courseType) {
        mNumOfCredits = numOfCredits;
        mName = name;
        mCourseType = courseType;
    }

    public enum CourseType {
        MATH, SCIENCE, ENGLISH, HISTORY, FOREEIGN_LANGUAGE, ARTS
    }

    public int getNumOfCredits() {
        return mNumOfCredits;
    }

    public void setNumOfCredits(int numOfCredits) {
        this.mNumOfCredits = numOfCredits;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public CourseType getCourseType() {
        return mCourseType;
    }

    public void setCourseType(CourseType courseType) {
        mCourseType = courseType;
    }

    @Override
    public String toString() {
        return "Course:";
    }

}
