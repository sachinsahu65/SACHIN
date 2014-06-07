package com.shop;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import com.shop.db.UserDb;

public class RegisterDetails extends GenericServlet {

	// UserDb userDb=new UserDb();
	Connection con = null;
	Statement st = null;
	int i = 0;
	String details = "";

	@Override
	public void service(ServletRequest request, ServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		String uname = request.getParameter("uname");
		String fname = request.getParameter("fname");
		String pwd = request.getParameter("pwd");
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");
		String gender = request.getParameter("gender");

		System.out.println(uname + fname + pwd + email + phone + gender);

		pw.print("before connection");

		try {

			con = UserDb.getOracleConnection();
			System.out.println("got connection");
			pw.print(" connection established");
			st = con.createStatement();
			pw.print("con stat");
			System.out.println("connection establish");
			details = "insert into userdb values(" + "'" + uname + "','"
					+ fname + "','" + pwd + "','" + email + "','" + phone
					+ "','" + gender + "')";
			System.out.println("details==" + details);
			i = st.executeUpdate(details);
			System.out.println(i);

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			System.out.println("inside finally");
			UserDb.Cleanup(st, con);
			System.out.println(i);
		}

	}

}
