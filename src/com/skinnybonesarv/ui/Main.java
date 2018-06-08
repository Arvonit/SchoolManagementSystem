package com.skinnybonesarv.ui;

import com.skinnybonesarv.controller.StudentController;
import com.skinnybonesarv.data.Student;
import com.skinnybonesarv.util.*;

import java.time.DateTimeException;
import java.util.*;

/**
 * @author SkinnyBonesArv
 */
public class Main {

    private static List<Student> sStudentList;
    private static Scanner sConsoleIn;

    static {
        if (Student.getFileLength() > 0) {
            sStudentList = Student.readFromFile();
        } else {
            sStudentList = new ArrayList<>();
        }
        sConsoleIn = new Scanner(System.in);
    }

    public static void main(String[] args) {
        int option = 0;

        System.out.println("-------------------------------------------------------------------------------------");
        System.out.println("Welcome to SkinnyBonesArv's School Management System!");
        System.out.println("Version: Alpha 1.0");
        System.out.println("-------------------------------------------------------------------------------------");

        while (option != 5) {
            try {
                if (sStudentList.size() < 1) {
                    System.out.println("\nSince this is either the first run of the program or there are no students left," +
                            " you must create one student.");
                    StudentController.addStudent(sStudentList);
                } else {
                    System.out.println("\nWould you like to:\n" +
                            "\t- Add a student (1)\n" +
                            "\t- Remove a student (2)\n" +
                            "\t- Modify a student (3)\n" +
                            "\t- View all students (4)\n" +
                            "\t- Exit the program (5)");

                    option = Integer.parseInt(sConsoleIn.nextLine());
                    System.out.println();

                    switch (option) {
                        case 1:
                            StudentController.addStudent(sStudentList);
                            break;
                        case 2:
                            StudentController.removeStudent(sStudentList);
                            break;
                        case 3:
                            StudentController.modifyStudent(sStudentList);
                            break;
                        case 4:
                            StudentController.viewAllStudents(sStudentList);
                            break;
                        case 5:
                            break;
                        default:
                            System.out.println("Invalid option.");
                            break;
                    }
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid number entered.");
            } catch (StringFormatException e) {
                System.out.println("Input can only contain letters.");
            } catch (DateTimeException e) {
                System.out.println("Invalid date entered.");
            } catch (IllegalArgumentException e) {
                System.out.println("Invalid sex entered.");
            } catch (IndexOutOfBoundsException e) {
                System.out.println("Invalid id number entered.");
            }
        }
    }

}
