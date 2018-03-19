package com.test;

import java.util.ArrayList;
import java.util.List;

public class StudentManagment {

    private List<Student> students = new ArrayList<Student>();

    public void addStudent() {
        FileManagement.addToFile(students);
    }

}
