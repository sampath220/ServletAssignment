package com.sampath;

import org.json.JSONException;
import org.json.JSONObject;

class Person {
	private String name;
	private int age;
	private String email;

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getAge() {
		return age;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEmail() {
		return email;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null || obj.getClass() != this.getClass()) {
			return false;
		}
		Person person = (Person) obj;
		if(person.name!="" && !name.equals(person.name))
			return false;
		if(person.age!=-1 && age!=person.age)
			return false;
		if(person.email!="" && !email.equals(person.email))
			return false;
		return true;
	}
	public int hashCode() {
        int result = 17;
        result = 31 * result + name.hashCode();
        result = 31 * result + age;
        result = 31 * result + email.hashCode();
        return result;
    }
	@Override
	public String toString() {
		return "{name:" + name + ",age:" + age + ",email:" + email + "}";
	}
	public JSONObject getJson() {
		try {
			return new JSONObject(toString());
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
