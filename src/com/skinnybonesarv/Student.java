package com.skinnybonesarv;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * TODO: Create student info file in native documents folder.
 *
 * @author SkinnyBonesArv
 * @see Person
 */
public class Student extends Person {

    private int mGrade;
    private static File sFile = new File("student_info.txt");
    private static int sNumOfStudents = 0;

    public Student(String lastName, String firstName, LocalDate dateOfBirth, Sex sex, int grade) {
        super(lastName, firstName, dateOfBirth, sex);
        mGrade = grade;
        sNumOfStudents++;
        super.setID(sNumOfStudents);
    }

    public int getGrade() {
        return mGrade;
    }

    public void setGrade(int grade) {
        mGrade = grade;
    }

    public static List<Student> readFromFile() {
        if (sFile.length() > 0) {
            try (Scanner in = new Scanner(sFile)) {
                List<Student> studentList = new ArrayList<>();
                sNumOfStudents = 0;
                while (in.hasNextLine()) {
                    String[] lineParts = in.nextLine().split(", ");

                    String lastName = lineParts[0];
                    String firstName = lineParts[1];
                    String[] dateOfBirthArr = lineParts[2].split("-");
                    LocalDate dateOfBirth = LocalDate.of(Integer.parseInt(dateOfBirthArr[0]), Integer.parseInt(dateOfBirthArr[1]),
                            Integer.parseInt(dateOfBirthArr[2]));
                    Sex sex = Sex.valueOf(lineParts[3]);
                    int grade = Integer.parseInt(lineParts[4]);
                    int id = Integer.parseInt(lineParts[5]);

                    Student s = new Student(lastName, firstName, dateOfBirth, sex, grade);
                    s.setID(id);
                    studentList.add(s);
                }
                return studentList;
            } catch (FileNotFoundException e) {
                e.printStackTrace();
                return null;
            }
        } else {
            return null;
        }
    }

    public static void saveChangesToFile(List<Student> studentList) {
        try (PrintWriter out = new PrintWriter(sFile)) {
            for (Student s : studentList)
                out.println(s.toFile());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static int getFileLength() {
        try {
            return (int) sFile.length();
        } catch (Exception e) {
            return -1;
        }
    }

    @Override
    protected String toFile() {
        return super.toFile() + new String().format("%d, %d", getGrade(), super.getID());
    }

    @Override
    public String toString() {
        return super.toString() + new String().format("%-10d %d", getGrade(), super.getID());
    }

    @Override
    public void writeToFile() {
        try (PrintWriter out = new PrintWriter(new FileOutputStream(sFile, true))) {
            out.println(toFile());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

}
