package com.shop;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import com.shop.db.UserDb;

public class LoginDetails extends GenericServlet {

	@Override
	public void service(ServletRequest request, ServletResponse response)
			throws ServletException, IOException {
		java.sql.Connection con = null;
		try {
			con = UserDb.getOracleConnection();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		String name = request.getParameter("UserName");
		String pass = request.getParameter("Password");
		System.out.println(name);
		pw.print(name);
		pw.print("\n");
		pw.print(pass);

		// Statment object

		Statement stm = null;

		if ((name.equals("") || name == null)
				|| (pass.equals("") || pass == null)) {
			pw.print("<html><body><h2>Caution</h2>");
			pw.print("<p>Your name and password is wrong</p>");
			pw.print("Please enter valid name and password");
			pw.print("<a href='Index.html'>Home</a>");
			pw.print("</body></html>");
		} else {

			pw.print("your name and password is valid");

		}
	}

}
