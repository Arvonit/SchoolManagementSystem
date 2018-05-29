package com.skinnybonesarv;

import java.util.Comparator;

/**
 * @author Arvind
 */
public class PersonIDComparator implements Comparator<Person> {

    @Override
    public int compare(Person a, Person b) {
        return Integer.compare(a.getID(), b.getID());
    }

}
