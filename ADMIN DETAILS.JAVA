package com.shop;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class AdminDetails extends GenericServlet {

	public void service(ServletRequest request, ServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		String name = request.getParameter("UserName");
		String pass = request.getParameter("Password");
		System.out.println(name);
		pw.print(name);
		pw.print("\n");
		pw.print(pass);

		RequestDispatcher rd = request.getRequestDispatcher("AdminMenu.html");

		if (name.equals("sachin") && (pass.equals("sahu"))) {
			pw.print("your name and password is valid");
			rd.forward(request, response);

		} else {
			pw.print("<html><body><h2>Caution</h2>");
			pw.print("<p>Admin name and password is wrong</p>");
			pw.print("Please enter valid name and password");
			pw.print("<a href='Index.html'>Home</a>");
			pw.print("</body></html>");

		}
	}

}
