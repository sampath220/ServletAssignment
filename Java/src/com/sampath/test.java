package com.sampath;

import java.util.ArrayList;

import org.json.JSONException;

public class test {
	public static void main(String[] args) throws JSONException  {
		DataSource.data = new ArrayList<Person>();
		Person p=new Person();
		p.setAge(25);
		p.setEmail("sa@gmial.com");
		p.setName("sample");
		DataSource.data.add(p);
		
		p=new Person();
		p.setAge(35);
		p.setEmail("samp@yahoo");
		p.setName("samp");
		DataSource.data.add(p);
		
		p=new Person();
		p.setAge(25);
		p.setEmail("valid@ggk");
		p.setName("valid");
		DataSource.data.add(p);
		p=new Person();
		
		p.setAge(28);
		p.setEmail("s.a@gmail.com");
		p.setName("raju");
		DataSource.data.add(p);
		//System.out.println(DataSource.getArrayData());
	}
}
