package com.sampath;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONException;
import org.json.JSONObject;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

/**
 * Servlet implementation class Storage
 */
@WebServlet("/Storage")
public class Storage extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void init() {
		DataSource.data = new ArrayList<Person>();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			Person p = new Person();
			try {
				JSONObject person=new JSONObject((request.getAttribute("person")).toString());
				p.setName(person.getString("name"));
				p.setAge(person.getInt("age"));
				p.setEmail(person.getString("email"));
				DataSource.data.add(p);
				response.getWriter().append("Submitted successfully");
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}

}
