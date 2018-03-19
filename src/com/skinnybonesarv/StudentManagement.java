package com.skinnybonesarv;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StudentManagement {
    /*private List<Student> studentList = new ArrayList<Student>();
    private Scanner fileReader;
    private Scanner in;

    public void getStudents(String firstName, String lastName, String sex, int grade, int monthBorn, int dayBorn,
                            int yearBorn, int id) {
        fileReader = new Scanner(System.in);

        // Loop through file to store all values in ArrayList and print them all out
        while(fileReader.hasNext()) {
            firstName = fileReader.next();
            lastName = fileReader.next();
            sex = fileReader.next();
            grade = fileReader.nextInt();
            monthBorn = fileReader.nextInt();
            dayBorn = fileReader.nextInt();
            yearBorn = fileReader.nextInt();
            id = fileReader.nextInt();

            // Save all values in ArrayList
            studentList.add(new Student(firstName, lastName, sex, grade, monthBorn, dayBorn, yearBorn, id));
        }

        fileReader.close();
    }

    public void viewStudents() {
        for(int idx = 0; !studentList.isEmpty(); idx++) {
            System.out.println(studentList.get(idx));
        }
    }

    public Student addStudent(Student s) {
        //ArrayList<Student> studentList = new ArrayList<Student>();
        fileReader = new Scanner(file);
        in = new Scanner(System.in);
        String text = "";
        int id;

        if (fileReader.hasNext()) {
            while (fileReader.hasNext()) {
                text = fileReader.next();
            }
            id = Integer.parseInt(text);
        } else {
            id = 0;
        }

        System.out.print("Enter first name: ");
        String firstName = in.next();

        System.out.print("Enter last name: ");
        String lastName = in.next();

        System.out.print("Enter sex: ");
        String sex = in.next();

        System.out.print("Enter grade: ");
        int grade = in.nextInt();

        System.out.println("Enter date of birth - Month, Day, Year (in number form and separated by enter): ");
        int monthBorn = in.nextInt();
        int dayBorn = in.nextInt();
        int yearBorn = in.nextInt();

        id++;

        s = new Student(firstName, lastName, sex, grade, monthBorn, dayBorn, yearBorn, id);
        //studentList.add(new Student(firstName, lastName, sex, grade, monthBorn, dayBorn, yearBorn, id));

        System.out.println();

        fileReader.close();
        return s;
    }

    public void addToList() {

    }

    public void removeStudent() {

    }

    public void sortStudents() {
        System.out.println("Choose one of the options to sort the data by:");
        System.out.println("    1. First Name");
        System.out.println("    2. Last Name");
        System.out.println("    3. Grade");
        System.out.println("    4. Sex");
        System.out.println("    5. DOB");
        System.out.println("    6. ID");
    }*/
}
