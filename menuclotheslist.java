package com.shop;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shop.db.UserDb;

/**
 * Servlet implementation class MensClothList
 */
public class MensClothList extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public MensClothList() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();

		Connection con = null;
		Statement stm = null;
		ResultSet rs = null;
		String sql = null;

		try {
			con = UserDb.getOracleConnection();
			stm = con.createStatement();
			sql = "select * from mencloths";
			rs = stm.executeQuery(sql);
			String brand;
			String size;
			String cost;
			String type;
			String id;

			if (rs.next()) {
				do {
					brand = rs.getString("brand");
					size = rs.getString("sizet");
					cost = rs.getString("cost");
					type = rs.getString("type");
					id = rs.getString("clothid");
					pw.print("<html><body>" + "Brand =" + brand + "<br>size ="
							+ size + "<br>cost =" + cost + "<br>type =" + type
							+ "<br>Customer id =" + id + "<br><br><br></body></html>");
				} while (rs.next());

			} else {
				pw.print("Out Of Stock");
			}

		} catch (SQLException ex) {
			ex.printStackTrace();
		} catch (ClassNotFoundException ex) {
			ex.printStackTrace();
		} finally {
			UserDb.Cleanup(rs, stm, con);
		}
	}

}
