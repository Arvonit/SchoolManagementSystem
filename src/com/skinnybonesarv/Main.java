/**
 * @author SkinnyBonesArv
 * @version 1/15/2018
 */

package com.skinnybonesarv;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * To-Do:
 * - Finish ability to modify students
 * - Modify code for removing students to be cleaner and more efficient
 * - Add the ability for teachers to managed
 * - Add abstract class/interface for human object so that teacher and student objects can have a parent object
 * - Move student management functionality from FileIO class
 * - Organize program in more packages
 *
 * Possible Changes:
 * - Use SQL database or JSON file instead of .txt file
 * - Add ability for user to manage classes/schedule for a student
 * - Make program GUI-based through JavaFX or Android
 * - Use a framework to modularize the code even more (like MVC)
 */

public class Main {

    public static void main(String[] args) {
        try {
            // ----------- DECLARATIONS -----------
            FileIO fileIO = new FileIO();
            File studentInfoFile = fileIO.createFile("student_info");

            ArrayList<Student> studentList;

            int choice;
            int number;

            Scanner in = new Scanner(System.in);

            // ----------- WELCOME SCREEN -----------
            System.out.println("-------------------------------------------------------------------------------------");
            System.out.println("Welcome to the School Management System!");
            System.out.println("Version: Alpha 2.0");
            System.out.println("Copyright © 2017 SkinnyBonesArv.  All rights reserved.");
            System.out.println("-------------------------------------------------------------------------------------");

            // ----------- MAIN SCREEN -----------
            if (!(fileIO.isFileEmpty(studentInfoFile))) {
                while (true) {
                    System.out.println();
                    System.out.print("Would you like to add students (1), remove students (2), " +
                            "or modify students (3)? ");
                    choice = in.nextInt();

                    switch (choice) {
                        case 1:
                            // Input number of students to add
                            System.out.print("How many students would you like to add?  ");
                            number = in.nextInt();

                            studentList = FileIO.createStudent(studentInfoFile, number, in);
                            FileIO.addStudent(studentInfoFile, studentList);
                            break;
                        case 2:
                            // Display students
                            System.out.println("First: Last: Sex: Grade: Date of Birth: ID:");
                            studentList = FileIO.viewStudents(studentInfoFile);

                            // Input ID of the student to delete
                            System.out.print("Enter the ID of the student you wish to remove: ");
                            choice = in.nextInt();

                            FileIO.deleteStudent(studentInfoFile, studentList, choice);

                            studentList = FileIO.viewStudents(studentInfoFile);
                            break;
                        case 3:
                            // Display students
                            System.out.println("First: Last: Sex: Grade: Date of Birth: ID:");
                            studentList = FileIO.viewStudents(studentInfoFile);

                            // Input ID of the student to modify
                            System.out.print("Enter the ID of the student you wish to remove: ");
                            choice = in.nextInt();

                            FileIO.modifyStudent(studentInfoFile, studentList, choice);

                            studentList = FileIO.viewStudents(studentInfoFile);
                            break;
                        default:
                            break;
                    }
                }
                // ----------- FIRST TIME USE SCREEN -----------
            } else {
                System.out.println();
                System.out.println("Welcome to the student setup configuration!");

                // Input number of students to add
                System.out.print("How many students would you like to add? (You can add more later.) ");
                number = in.nextInt();

                studentList = FileIO.createStudent(studentInfoFile, number, in);
                FileIO.addStudent(studentInfoFile, studentList);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}