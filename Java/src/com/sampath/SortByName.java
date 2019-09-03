package com.sampath;

import java.util.Comparator;

public class SortByName implements Comparator<Person> {
	
	public int compare(Person a, Person b) {
		return a.getName().compareTo(b.getName());
	}
}

