package com.sampath;
import com.sampath.*;
import java.util.Comparator;

public class SortByEmail implements Comparator<Person> {

	public int compare(Person a, Person b) {
		return a.getEmail().compareTo(b.getEmail());
	}
}