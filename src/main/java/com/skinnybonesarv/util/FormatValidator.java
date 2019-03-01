package com.skinnybonesarv.util;

/**
 * @author Arvind
 */
public class FormatValidator {

    public static String checkStringFormat(String s) throws StringFormatException {
        char[] charArr = s.toCharArray();

        if (s.equals("")) {
            throw new StringFormatException();
        } else {
            for (char c : charArr)
                if (!Character.isLetter(c))
                    throw new StringFormatException();
        }

        return s;
    }

    public static int checkGrade(int i) {
        if (i >= 0 && i <= 12)
            return i;
        else
            return -1; // Replace with ~GradeException
    }

}
