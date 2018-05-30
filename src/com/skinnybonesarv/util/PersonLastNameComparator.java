package com.skinnybonesarv.util;

import com.skinnybonesarv.data.Person;

import java.util.Comparator;

/**
 * @author SkinnyBonesArv
 */
public class PersonLastNameComparator implements Comparator<Person> {

    @Override
    public int compare(Person a, Person b) {
        return a.getLastName().compareTo(b.getLastName());
    }

}
