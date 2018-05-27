package com.skinnybonesarv.beta;

import java.util.ArrayList;
import java.util.List;

public class StudentManagment {

    private List<Student> students = new ArrayList<>();

    public void addStudent() {
        FileManagement.addToFile(students);
    }

}
