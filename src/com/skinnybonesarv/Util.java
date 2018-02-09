package com.skinnybonesarv;

import javax.swing.filechooser.FileSystemView;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.Scanner;

public class Util {
    public String getOS() {
        return System.getProperty("os.name").toLowerCase();
    }

}
