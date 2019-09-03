package com.sampath;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;

/**
 * Servlet implementation class Sorting
 */
@WebServlet("/Sorting")
public class Sorting extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String field = request.getParameter("field");
		System.out.println(field);
		String order = request.getParameter("order");
		List<Person> result = null;
		System.out.println(field);
		if (field.equals("name")) {
			Collections.sort(DataSource.data, new SortByName());
		} else if (field.equals("age")) {
			Collections.sort(DataSource.data, new SortByAge());
		} else {
			Collections.sort(DataSource.data, new SortByEmail());
		}

		PrintWriter out = response.getWriter();
		if (order.equals("desc"))
			Collections.reverse(DataSource.data);
		if (DataSource.data.size() == 0)
			out.print("No records found");
		else {
			JSONArray output = new JSONArray();
			for (Person p : DataSource.data) {
				output.put(p.getJson());
			}
			response.getWriter().println(output);
		}
		out.flush();
		out.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
