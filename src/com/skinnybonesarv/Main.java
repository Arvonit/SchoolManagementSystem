package com.skinnybonesarv;

import java.time.LocalDate;
import java.util.Collections;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

/**
 * @author SkinnyBonesArv
 */
public class Main {

    private static List<Student> sStudentList = null;
    private static Scanner sConsoleIn = new Scanner(System.in);

    public static void main(String[] args) {
        int option = 0;

        System.out.println("-------------------------------------------------------------------------------------");
        System.out.println("Welcome to SkinnyBonesArv's School Management System!");
        System.out.println("Version: Alpha 1.0");
        System.out.println("-------------------------------------------------------------------------------------");

        if (Student.getFileLength() > 0) {
            sStudentList = Student.readFromFile();
        } else {
            System.out.println("Since this is either the first run of the program or there are no students left," +
                    " you must create one student.");
            addStudent();
        }

        while (option != 5) {
            System.out.println("\nWould you like to:\n" +
                    "\t- Add a student (1)\n" +
                    "\t- Remove a student (2)\n" +
                    "\t- Modify a student (3)\n" +
                    "\t- View all students (4)\n" +
                    "\t- Exit the program (5)");
            try {
                option = sConsoleIn.nextInt();
                System.out.println();

                switch (option) {
                    case 1:
                        addStudent();
                        break;
                    case 2:
                        removeStudent();
                        break;
                    case 3:
                        modifyStudent();
                        break;
                    case 4:
                        viewAllStudents();
                        break;
                    case 5:
                        break;
                    default:
                        System.out.println("Invalid option.");
                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input type.");
            }
        }
    }

    private static void addStudent() {
        System.out.print("Enter last name: ");
        String lastName = sConsoleIn.next();

        System.out.print("Enter first name: ");
        String firstName = sConsoleIn.next();

        System.out.print("Enter sex (Male, Female, or Other): ");
        String sexStr = sConsoleIn.next();

        System.out.print("Enter year of birth: ");
        int yearBorn = sConsoleIn.nextInt();
        System.out.print("Enter month of birth: ");
        int monthBorn = sConsoleIn.nextInt();
        System.out.print("Enter day of birth: ");
        int dayBorn = sConsoleIn.nextInt();

        System.out.print("Enter grade: ");
        int grade = sConsoleIn.nextInt();

        sStudentList.add(new Student(lastName, firstName, LocalDate.of(yearBorn, monthBorn, dayBorn),
                Person.Sex.valueOf(sexStr.toUpperCase()), grade));
        sStudentList.get(sStudentList.size() - 1).writeToFile();

        System.out.println("Operation completed successfully.");
    }

    private static void removeStudent() {
        viewAllStudents();
        int id = 0;
        System.out.print("\nEnter the ID # of the student you'd like to remove: ");
        try {
            id = sConsoleIn.nextInt();

            Student s = new Student(id);
            int i = Collections.binarySearch(sStudentList, s, new PersonIDComparator());
            sStudentList.remove(i);
            Student.saveChangesToFile(sStudentList);
            System.out.println("Operation completed successfully.");
        } catch (InputMismatchException e) {
            System.out.println("Invalid input type.");
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Invalid id number.");
        }
    }

    private static void modifyStudent() {
    	viewAllStudents();
    	int id = 0;
    	int choice = 0;
        System.out.print("\nEnter the ID # of the student you'd like to modify: ");
        try {
            id = sConsoleIn.nextInt();

            Student s = new Student(id);
            int i = Collections.binarySearch(sStudentList, s, new PersonIDComparator());

            System.out.println("Which part of the student would you like to modify?\n" +
                    "\t- Last Name (1)\n" +
                    "\t- First Name (2)\n" +
                    "\t- Sex (3)\n" +
                    "\t- Date of Birth (4)\n" +
                    "\t- Grade (5)");
            choice = sConsoleIn.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter new last name: ");
                    String lastName = sConsoleIn.next();
                    sStudentList.get(i).setLastName(lastName);
                    break;
                case 2:
                    System.out.print("Enter new first name: ");
                    String firstName = sConsoleIn.next();
                    sStudentList.get(i).setFirstName(firstName);
                    break;
                case 3:
                    System.out.print("Enter new sex (Male, Female, or Other): ");
                    String sexStr = sConsoleIn.next();
                    sStudentList.get(i).setSex(Person.Sex.valueOf(sexStr.toUpperCase()));
                    break;
                case 4:
                    System.out.print("Enter new year of birth: ");
                    int yearBorn = sConsoleIn.nextInt();
                    System.out.print("Enter new month of birth: ");
                    int monthBorn = sConsoleIn.nextInt();
                    System.out.print("Enter new day of birth: ");
                    int dayBorn = sConsoleIn.nextInt();
                    sStudentList.get(i).setDateOfBirth(LocalDate.of(yearBorn, monthBorn, dayBorn));
                    break;
                case 5:
                    System.out.print("Enter new grade: ");
                    int grade = sConsoleIn.nextInt();
                    sStudentList.get(i).setGrade(grade);
                    break;
            }

            Student.saveChangesToFile(sStudentList);
            System.out.println("Operation completed successfully.");
        } catch (InputMismatchException e) {
            System.out.println("Invalid input type.");
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Invalid id number.");
        }
    }

    private static void viewAllStudents() {
        System.out.printf("%-15s %-15s %-20s %-10s %-10s %s%n", "Last Name:", "First Name:", "Date of Birth:", "Sex:",
                "Grade:", "ID #:");
        // Sort list alphabetically based on last name
        Collections.sort(sStudentList, new PersonLastNameComparator());
        for (Student s : sStudentList)
            System.out.println(s);

        // Sort list by id for other operations (mainly for saving changes to the file)
        Collections.sort(sStudentList, new PersonIDComparator());
    }

}
