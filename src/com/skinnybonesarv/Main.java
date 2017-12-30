package com.skinnybonesarv;

import javax.swing.filechooser.FileSystemView;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        try {
            // Misc.
            String documentsDir = FileSystemView.getFileSystemView().getDefaultDirectory().getPath();
            String schoolName;

            Scanner userIn = new Scanner(System.in);

            // Student Info
            File studentInfoFile = new File(documentsDir + "\\student_info.txt");
            FileWriter studentInfoIn = new FileWriter(studentInfoFile, true);
            Scanner studentInfoOut = new Scanner(studentInfoFile);

            // School Info
            File schoolInfoFile = new File(documentsDir + "\\school_info.txt");
            FileWriter schoolInfoIn = new FileWriter(schoolInfoFile, true);
            Scanner schoolInfoOut = new Scanner(schoolInfoFile);

            // ----------- Setup -----------
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

            schoolInfoIn.close();
            schoolInfoOut.close();
        } catch(IOException e) {
            e.printStackTrace();
        }
    }
}
