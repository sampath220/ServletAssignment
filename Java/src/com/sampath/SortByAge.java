package com.sampath;

import java.util.Comparator;

public class SortByAge implements Comparator<Person> {

	public int compare(Person a, Person b) {
		return a.getAge() - b.getAge();
	}
}