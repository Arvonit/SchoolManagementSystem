/**
 * @author SkinnyBonesArv
 * @version 1/15/2018
 */

package com.skinnybonesarv;

import javax.swing.filechooser.FileSystemView;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class FileIO {
    // ---------- DECLARATIONS ----------
    private static String firstName;
    private static String lastName;
    private static String sex;
    private static int grade;
    private static int yearBorn;
    private static int monthBorn;
    private static int dayBorn;
    private static int id;
    private static int numOfLines;
    private static int idx;

    // ---------- CHECK IF FILE IS EMPTY ----------
    public static boolean isFileEmpty(File file) throws FileNotFoundException {
        Scanner fileReader = new Scanner(file);
        return fileReader.hasNext();
    }

    // ---------- CREATE AND STORE FILE BASED ON GIVEN NAME ----------
    public File createFile(String fileName) {
        return new File(System.getProperty("user.home") + File.separator + fileName + ".txt");
    }

    // ---------- GET THE NUMBER OF LINES IN A FILE ----------
    public static int getFileLength(File file) throws FileNotFoundException {
        Scanner fileReader = new Scanner(file);
        numOfLines = 0;

        while (fileReader.hasNextLine()) {
            numOfLines++;
            fileReader.nextLine();
        }

        return numOfLines;
    }

    // ---------- CREATE STUDENT AND ADD STUDENT TO ARRAYLIST OF TYPE STUDENT ----------
    public static ArrayList<Student> createStudent(File file, int numOfStudents, Scanner in)
            throws FileNotFoundException {
        ArrayList<Student> studentList = new ArrayList<Student>();
        Scanner fileReader = new Scanner(file);
        String text = "";

        if (!(isFileEmpty(file))) {
            while (fileReader.hasNext()) {
                text = fileReader.next();
            }

            id = Integer.parseInt(text);
        } else {
            id = 0;
        }


        for (idx = 0; idx < numOfStudents; idx++) {
            System.out.print("Enter first name: ");
            firstName = in.next();

            System.out.print("Enter last name: ");
            lastName = in.next();

            System.out.print("Enter sex: ");
            sex = in.next();

            System.out.print("Enter grade: ");
            grade = in.nextInt();

            System.out.println("Enter date of birth - Month, Day, Year (in number form and separated by enter): ");
            monthBorn = in.nextInt();
            dayBorn = in.nextInt();
            yearBorn = in.nextInt();

            id++;

            studentList.add(new Student(firstName, lastName, sex, grade, monthBorn, dayBorn, yearBorn, id));

            System.out.println();
        }

        fileReader.close();

        return studentList;
    }


    // ---------- ADD STUDENT TO THE FILE ----------
    public static void addStudent(File file, ArrayList<Student> studentList) throws IOException {
        FileWriter fileWriter = new FileWriter(file, true);

        for (idx = 0; idx < studentList.size(); idx++) {
            Student student = studentList.get(idx);

            if (!(isFileEmpty(file))) {
                fileWriter.append(System.lineSeparator());
            }

            fileWriter.append(student.getFirstName() + " " + student.getLastName() + " " + student.getSex() + " " +
                    student.getGrade() + " " + student.getMonthBorn() + " " + student.getDayBorn() + " " +
                    student.getYearBorn() + " " + student.getID());

            System.out.println("Operation successful.");
            System.out.println();
        }

        fileWriter.close();
    }

    // ---------- VIEW ALL STUDENTS IN FILE ----------
    public static ArrayList<Student> viewStudents(File file) throws FileNotFoundException {
        // Declarations
        ArrayList<Student> studentList = new ArrayList<Student>();
        Scanner fileReader = new Scanner(file);
        numOfLines = getFileLength(file);

        // Loop through file to store all values in ArrayList and print them all out
        for (idx = 0; idx < numOfLines; idx++) {
            firstName = fileReader.next();
            lastName = fileReader.next();
            sex = fileReader.next();
            grade = fileReader.nextInt();
            monthBorn = fileReader.nextInt();
            dayBorn = fileReader.nextInt();
            yearBorn = fileReader.nextInt();
            id = fileReader.nextInt();

            // Print out all values in the idx-th line of file
            System.out.println(firstName + " " + lastName + " " + sex + " " + grade + " " + monthBorn + "-" +
                    dayBorn + "-" + yearBorn + " " + id);

            // Save all values in ArrayList
            studentList.add(new Student(firstName, lastName, sex, grade, monthBorn, dayBorn, yearBorn, id));
        }

        fileReader.close();

        return studentList;
    }

    // ---------- REMOVE A STUDENT FROM THE STUDENTLIST ARRAYLIST ----------
    public static void deleteStudent(File file, ArrayList<Student> studentList, int id) throws IOException {
        // Declarations
        FileWriter fileWriter = new FileWriter(file, true);
        numOfLines = getFileLength(file);
        int delLineNum = 0;
        Student student;

        // Loop through ArrayList until given ID is the same as the ID in the idx-th row of ArrayList
        for (idx = 0; idx < numOfLines; idx++) {
            student = studentList.get(idx);
            // Exit loop if IDs are the same
            if (id == student.getID()) {
                delLineNum = idx;
            }
        }

        // Remove the row in the ArrayList that contains the given ID
        studentList.remove(delLineNum);
        rewriteFile(file, studentList);

        fileWriter.close();
    }

    public static void modifyStudent(File file, ArrayList<Student> studentList, int id) throws IOException {
        // Declarations
        FileWriter fileWriter = new FileWriter(file, true);
        numOfLines = getFileLength(file);
        int delLineNum = 0;
        Student student;
        int choice;
        Scanner in = new Scanner(System.in);

        // Loop through ArrayList until given ID is the same as the ID in the idx-th row of ArrayList
        for (idx = 0; idx < numOfLines; idx++) {
            student = studentList.get(idx);
            // Exit loop if IDs are the same
            if (id == student.getID()) {
                delLineNum = idx;
            }
        }

        // Ask user to which parts of student to modify
        System.out.println("Which part of the student would you like to modify? ");
        System.out.println("First Name (1)\n" +
                "Last Name (2)\n" +
                "Sex (3)\n" +
                "Grade (4)\n" +
                "Date of Birth (5)\n");
        choice = in.nextInt();
        student = studentList.get(delLineNum);

        switch (choice) {
            case 1:
                System.out.println("Enter new first name: ");
                firstName = in.next();
                student.setFirstName(firstName);
                break;
            case 2:
                lastName = in.next();
                student.setLastName(lastName);
                break;
            case 3:
                sex = in.next();
                student.setSex(sex);
                break;
            case 4:
                grade = in.nextInt();
                student.setGrade(grade);
                break;
            case 5:
                monthBorn = in.nextInt();
                dayBorn = in.nextInt();
                yearBorn = in.nextInt();
                student.setMonthBorn(monthBorn);
                student.setDayBorn(dayBorn);
                student.setYearBorn(yearBorn);
                break;
            default:
                break;
        }
    }

    // ---------- REWRITE THE FILE USING NEW ARRAYLIST ----------
    private static void rewriteFile(File file, ArrayList<Student> studentList) throws IOException {
        FileWriter fileWriter = new FileWriter(file);

        for (idx = 0; idx < studentList.size(); idx++) {
            Student student = studentList.get(idx);

            // Figure out why isFileEmpty(file) method won't work here
            if (idx > 0) {
                fileWriter.append(System.lineSeparator());
            }

            fileWriter.append(student.getFirstName() + " " + student.getLastName() + " " + student.getSex() + " " +
                    student.getGrade() + " " + student.getMonthBorn() + " " + student.getDayBorn() + " " +
                    student.getYearBorn() + " " + student.getID());
        }

        System.out.println("Operation successful.");

        fileWriter.close();
    }
}
