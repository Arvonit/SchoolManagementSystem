package com.skinnybonesarv.controller;

import com.skinnybonesarv.data.Person;
import com.skinnybonesarv.data.Student;
import com.skinnybonesarv.util.FormatValidator;
import com.skinnybonesarv.util.PersonIDComparator;
import com.skinnybonesarv.util.PersonLastNameComparator;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * @author Arvind
 */
public class StudentController {

    private static Scanner sConsoleIn = new Scanner(System.in);

    public static void addStudent(List<Student> studentList) {
        System.out.print("Enter last name: ");
        String lastName = FormatValidator.checkStringFormat(sConsoleIn.nextLine());
        System.out.print("Enter first name: ");
        String firstName = FormatValidator.checkStringFormat(sConsoleIn.nextLine());

        System.out.print("Enter sex (Male, Female, or Other): ");
        String sexStr = FormatValidator.checkStringFormat(sConsoleIn.nextLine());
        Person.Sex sex = Person.Sex.valueOf(sexStr.toUpperCase());

        System.out.print("Enter year of birth (YYYY): ");
        int yearBorn = Integer.parseInt(sConsoleIn.nextLine());
        System.out.print("Enter month of birth (MM): ");
        int monthBorn = Integer.parseInt(sConsoleIn.nextLine());
        System.out.print("Enter day of birth (DD): ");
        int dayBorn = Integer.parseInt(sConsoleIn.nextLine());
        LocalDate dateOfBirth = LocalDate.of(yearBorn, monthBorn, dayBorn);

        System.out.print("Enter grade: ");
        int grade = Integer.parseInt(sConsoleIn.nextLine());

        studentList.add(new Student(lastName, firstName, dateOfBirth, sex, grade));
        studentList.get(studentList.size() - 1).writeToFile();

        System.out.println("Operation completed successfully.");
    }

    public static void removeStudent(List<Student> studentList) {
        viewAllStudents(studentList);
        int id = 0;
        System.out.print("\nEnter the ID # of the student you'd like to remove: ");
        id = Integer.parseInt(sConsoleIn.nextLine());

        // Search for a student with inputted ID # in list sorted by ID #
        Student s = new Student(id);
        int i = Collections.binarySearch(studentList, s, new PersonIDComparator());

        studentList.remove(i);
        Student.saveChangesToFile(studentList);
        System.out.println("Operation completed successfully.");
    }

    public static void modifyStudent(List<Student> studentList) {
        viewAllStudents(studentList);
        int id = 0;
        int choice = 0;
        System.out.print("\nEnter the ID # of the student you'd like to modify: ");
        id = Integer.parseInt(sConsoleIn.nextLine());

        // Search for a student with inputted ID # in list sorted by ID #
        Student s = new Student(id);
        int i = Collections.binarySearch(studentList, s, new PersonIDComparator());

        System.out.println("Which part of the student would you like to modify?\n" + "\t- Last Name (1)\n"
                + "\t- First Name (2)\n" + "\t- Date of Birth (3)\n" + "\t- Sex (4)\n" + "\t- Grade (5)");
        choice = Integer.parseInt(sConsoleIn.nextLine());

        switch (choice) {
            case 1:
                System.out.print("Enter new last name: ");
                String lastName = FormatValidator.checkStringFormat(sConsoleIn.nextLine());
                studentList.get(i).setLastName(lastName);
                break;
            case 2:
                System.out.print("Enter new first name: ");
                String firstName = FormatValidator.checkStringFormat(sConsoleIn.nextLine());
                studentList.get(i).setFirstName(firstName);
                break;
            case 3:
                System.out.print("Enter new year of birth (YYYY): ");
                int yearBorn = Integer.parseInt(sConsoleIn.nextLine());
                System.out.print("Enter new month of birth (MM): ");
                int monthBorn = Integer.parseInt(sConsoleIn.nextLine());
                System.out.print("Enter new day of birth (DD): ");
                int dayBorn = Integer.parseInt(sConsoleIn.nextLine());
                studentList.get(i).setDateOfBirth(LocalDate.of(yearBorn, monthBorn, dayBorn));
                break;
            case 4:
                System.out.print("Enter new sex (Male, Female, or Other): ");
                String sexStr = FormatValidator.checkStringFormat(sConsoleIn.nextLine());
                studentList.get(i).setSex(Person.Sex.valueOf(sexStr.toUpperCase()));
                break;
            case 5:
                System.out.print("Enter new grade: ");
                int grade = Integer.parseInt(sConsoleIn.nextLine());
                studentList.get(i).setGrade(grade);
                break;
        }

        Student.saveChangesToFile(studentList);
        System.out.println("Operation completed successfully.");
    }

    public static void viewAllStudents(List<Student> studentList) {
        System.out.printf("%-15s %-15s %-20s %-10s %-10s %s%n", "Last Name:", "First Name:", "Date of Birth:", "Sex:",
                "Grade:", "ID #:");
        // Sort list alphabetically based on last name
        Collections.sort(studentList, new PersonLastNameComparator());
        for (Student s : studentList)
            System.out.println(s);

        // Sort list by id for other operations (mainly for saving changes to the file)
        Collections.sort(studentList, new PersonIDComparator());
    }

}
