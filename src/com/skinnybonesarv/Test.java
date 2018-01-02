package com.skinnybonesarv;

import javax.swing.filechooser.FileSystemView;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        try {
            // ---------- DECLARATIONS & DEFINITIONS ----------
            // Misc.
            String documentsDir = FileSystemView.getFileSystemView().getDefaultDirectory().getPath();
            String schoolName = "";
            String firstName = "";
            String lastName = "";
            String sex = "";
            String phoneNum = "";
            int monthBorn = 0;
            int dayBorn = 0;
            int yearBorn = 0;
            int studentID = 0;
            int grade = 0;
            int numOfStudents = 0;
            int choice = 1;

            Scanner userIn = new Scanner(System.in);

            // Student Info
            File studentInfoFile = new File(documentsDir + "\\student_info.txt");
            FileWriter studentInfoIn = new FileWriter(studentInfoFile, true);
            Scanner studentInfoOut = new Scanner(studentInfoFile);

            // School Info
            File schoolInfoFile = new File(documentsDir + "\\school_info.txt");
            FileWriter schoolInfoIn = new FileWriter(schoolInfoFile, true);
            Scanner schoolInfoOut = new Scanner(schoolInfoFile);

            // ----------- SETUP -----------
            // Check if administrator has entered school name
            if (schoolInfoOut.hasNext()) {
                schoolName = schoolInfoOut.nextLine();
            } else {
                System.out.print("Enter the name of your school: ");
                schoolName = userIn.nextLine();
                schoolInfoIn.append(schoolName);
            }

            // ----------- Welcome Screen -----------
            System.out.println("-------------------------------------------------------------------------------------");
            System.out.println("Welcome to the " + schoolName + " Student Information System!");
            System.out.println("Version: Pre-Alpha 1.0");
            System.out.println("Copyright © 2017 SkinnyBonesArv.  All rights reserved.");
            System.out.println("-------------------------------------------------------------------------------------");

            // ----------- MAIN SCREEN -----------
            if (studentInfoOut.hasNext()) {
                while (choice != 0) {
                    System.out.println();
                    System.out.print("Would you like to modify student data (1) or school info (2)? ");
                    choice = userIn.nextInt();

                    switch (choice) {
                        case 1:
                            System.out.print("Would you like to add students (1), remove students (2)," +
                                    "or modify students (3)? ");
                            choice = userIn.nextInt();

                            switch (choice) {
                                case 1:
                                    // ---------- ADD STUDENT ----------

                                    // ----------- COPIED FROM STUDENT SETUP SCREEN -----------
                                    System.out.print("How many students would you like to add? (You can add more later.) ");
                                    numOfStudents = userIn.nextInt();

                                    // Add students based on input
                                    for (int idx = 0; idx < numOfStudents; idx++) {
                                        System.out.print("Enter first name: ");
                                        firstName = userIn.next();

                                        System.out.print("Enter last name: ");
                                        lastName = userIn.next();

                                        System.out.print("Enter sex: ");
                                        sex = userIn.next();

                                        System.out.print("Enter grade: ");
                                        grade = userIn.nextInt();

                                        System.out.print("Enter phone number: ");
                                        phoneNum = userIn.next();

                                        System.out.println("Enter date of birth (Month, day, year; seperated by enter): ");
                                        monthBorn = userIn.nextInt();
                                        dayBorn = userIn.nextInt();
                                        yearBorn = userIn.nextInt();

                                        studentInfoIn.append(firstName + System.lineSeparator());
                                        studentInfoIn.append(lastName + System.lineSeparator());
                                        studentInfoIn.append(sex + System.lineSeparator());
                                        studentInfoIn.append(grade + System.lineSeparator());
                                        studentInfoIn.append(phoneNum + System.lineSeparator());
                                        studentInfoIn.append(monthBorn + System.lineSeparator());
                                        studentInfoIn.append(dayBorn + System.lineSeparator());
                                        studentInfoIn.append(yearBorn + System.lineSeparator());

                                        System.out.println("Operation successful.");
                                    }
                                    break;
                                case 2:
                                    // ---------- REMOVE STUDENT ----------
                                    System.out.println();
                                    System.out.println("First: Last: Sex: Grade: Phone #: Date of Birth:");
                                    while(studentInfoOut.hasNext()) {
                                        firstName = studentInfoOut.next();
                                        lastName = studentInfoOut.next();
                                        sex = studentInfoOut.next();
                                        grade = studentInfoOut.nextInt();
                                        phoneNum = studentInfoOut.next();
                                        monthBorn = studentInfoOut.nextInt();
                                        dayBorn = studentInfoOut.nextInt();
                                        yearBorn = studentInfoOut.nextInt();

                                        System.out.println(firstName + " " + lastName + " " + sex + " " +
                                                grade + " " + phoneNum + " " + monthBorn + "-" + dayBorn + "-" +
                                                yearBorn);
                                    }

                                    // System.out.println("Enter the first name of the student you wish to remove.");
                                    // firstName = userIn.next();

                                    break;
                                default:
                                    System.out.println("Please enter 1, to add student, or 2, to remove students," +
                                            "or 3, modify students.");
                                    break;
                            }

                            break;
                        case 2:
                            // In progress
                            break;
                        default:
                            System.out.println("Please enter 1, to modify student data, or 2, to modify school info.");
                            break;
                    }
                }
            }
            // ----------- FIRST TIME USE -----------
            else {
                System.out.println("Welcome to the student setup configuration!");

                // Input num of students to add
                System.out.println();
                System.out.print("How many students would you like to add? (You can add more later.) ");
                numOfStudents = userIn.nextInt();

                // Add students based on input
                for (int idx = 0; idx < numOfStudents; idx++) {
                    System.out.print("Enter first name: ");
                    firstName = userIn.next();

                    System.out.print("Enter last name: ");
                    lastName = userIn.next();

                    System.out.print("Enter sex: ");
                    sex = userIn.next();

                    System.out.print("Enter grade: ");
                    grade = userIn.nextInt();

                    System.out.print("Enter phone number: ");
                    phoneNum = userIn.next();

                    System.out.println("Enter date of birth (Month, day, year; seperated by enter): ");
                    monthBorn = userIn.nextInt();
                    dayBorn = userIn.nextInt();
                    yearBorn = userIn.nextInt();

                    if(idx == 0) {
                        if(studentInfoOut.hasNext()) {
                            studentInfoIn.append(System.lineSeparator());
                        }
                    }

                    studentInfoIn.append(firstName + System.lineSeparator());
                    studentInfoIn.append(lastName + System.lineSeparator());
                    studentInfoIn.append(sex + System.lineSeparator());
                    studentInfoIn.append(grade + System.lineSeparator());
                    studentInfoIn.append(phoneNum + System.lineSeparator());
                    studentInfoIn.append(monthBorn + System.lineSeparator());
                    studentInfoIn.append(dayBorn + System.lineSeparator());
                    studentInfoIn.append(yearBorn + System.lineSeparator());

                    System.out.println("Operation successful.");
                }
            }

            studentInfoIn.close();
            studentInfoOut.close();
            schoolInfoIn.close();
            schoolInfoOut.close();
        } catch(IOException e) {
            e.printStackTrace();
        }
    }
}
