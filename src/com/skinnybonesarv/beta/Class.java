package com.skinnybonesarv.beta;

public class Class extends Course {

    private int period;

    public Class(int numOfCredits, String name, CourseType courseType, int period) {
        super(numOfCredits, name, courseType);
        this.period = period;
    }

    public int getPeriod() {
        return period;
    }

    public void setPeriod(int period) {
        this.period = period;
    }

}
