package com.skinnybonesarv.util;

import org.junit.Test;

import static org.junit.Assert.*;

public class FormatValidatorTest {

    @Test
    public void checkStringFormat() {
        String strOne = "@Name";
        String strTwo = "Name";
        String strThree = "Na me";
        String strFour = "Name1";

        assertEquals(strTwo, FormatValidator.checkStringFormat(strTwo));
    }

}