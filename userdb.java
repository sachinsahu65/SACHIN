package com.shop.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UserDb {

	public static Connection getOracleConnection()
			throws ClassNotFoundException, SQLException {
		Connection con = null;
		System.out.println("connection is calling");
		Class.forName("oracle.jdbc.driver.OracleDriver");
		System.out.println("class has been loaded");
		con = DriverManager.getConnection(
				"jdbc:oracle:thin:@localhost:1521:XE", "hr", "hr");
		System.out.println("connection loaded");

		return con;
	}

	public static void Cleanup(Statement st, Connection con) {
		try {
			if (st != null)
				st.close();
			if (con != null)
				con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void Cleanup(ResultSet rs, Statement st, Connection con) {
		try {
			if (rs != null)
				rs.close();
			if (st != null)
				st.close();
			if (con != null)
				con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
