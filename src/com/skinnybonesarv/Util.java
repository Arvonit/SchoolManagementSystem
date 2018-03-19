package com.skinnybonesarv;

import javax.swing.filechooser.FileSystemView;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.Scanner;

public class Util {
    // ---------- CREATE AND STORE FILE BASED ON GIVEN NAME ----------
    public File createFile(String fileName) {
        return new File(System.getProperty("user.home") + File.separator + fileName);
    }

    // ---------- GET THE NUMBER OF LINES IN A FILE ----------
    public static int getFileLength(File file) throws FileNotFoundException {
        Scanner fileReader = new Scanner(file);
        int numOfLines = 0;

        while (fileReader.hasNextLine()) {
            numOfLines++;
            fileReader.nextLine();
        }

        return numOfLines;
    }
}
