package com.sampath;

import java.io.BufferedReader;
import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

import org.json.JSONObject;

/**
 * Servlet Filter implementation class AddFilter
 */
@WebFilter("/AddFilter")
public class AddFilter implements Filter {

	/**
	 * Default constructor.
	 */
	public AddFilter() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		BufferedReader reader = request.getReader();
		String line = reader.readLine();
		request.setAttribute("person", line);
		for(Person p:DataSource.data)
		{
			System.out.println(p.getEmail());
			System.out.println(request.getAttribute("email"));
		}
		if (DataSource.data.stream().anyMatch(p -> p.getEmail().equals(request.getAttribute("email")))) {
			System.out.println("ale");
			response.getWriter().print("Email already exists");
		} else {
			chain.doFilter(request, response);
		}
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
