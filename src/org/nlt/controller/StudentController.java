package org.nlt.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import javax.servlet.GenericServlet;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class StudentController extends GenericServlet
{

	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		String name=req.getParameter("name");
		String age=req.getParameter("age");
		String phone=req.getParameter("phone");
		
		
		PrintWriter out=res.getWriter();
		res.setContentType("text/html");
		
		try {
				Class.forName("com.mysql.jdbc.Driver");
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/genericservlet","root","");
				Statement smt = con.createStatement();
				smt.execute("insert into persons2(name,age,phone,status) values('"+name+"',"+age+",'"+phone+"',1)");
				smt.close();
				con.close();
				out.println("<h2>Record Submitted Successfully</h2>");
				out.println("<h2><a href='./student.html'>Back</a></h2>");
			}
		catch (Exception e) 
		{
			out.println("<h2>"+e+"</h2>");
			out.println("<a href='./student.html'>Back</a>");
		}
	}
}
