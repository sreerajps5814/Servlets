package com.demo.crud.Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.demo.crud.DAO.EmployeeDAO;
import com.demo.crud.DTO.Employee;


@WebServlet("/EditServlet")
public class EditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
  	
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	
		res.setContentType("text/html");
		PrintWriter out=res.getWriter();
		out.println("Update Employees");	
		String sid=req.getParameter("id");
		int id =Integer.parseInt(sid);
		
		
		Employee e=EmployeeDAO.getByID(id);
								
		
			
		
				out.print("<form action='EditServlet2' method='post'>");
			out.print("<br><tr><td> Id  :</td><input type='hidden' name='id' value="+e.getId()+"><td></td></tr><br>");
			out.print("<br><tr><td> Name:</td><input type='text' name='name' value="+e.getName()+"><td></td></tr><br>");
			out.print("<tr><td> Password:</td><td><input type='text' name='pwd'value="+e.getPwd()+"></td></tr><br>");
			out.print("<tr><td> Email   :  </td><td><input type='email' name='email'value="+e.getEmail()+"></td></tr><br>");
			out.print("<tr><td> Country :</td><td><select name='ctry' value="+e.getCtry()+"'width: 145px;'><br>");
			out.print("<option>India</option>");
			out.print("<option>Usa</option>");
			out.print("<option>Russia</option>");
			out.print("<option>Other</option>");
			out.print("</select></td></tr><br>");
			out.print("<tr><td><input type='submit' value='update' ></td></tr><br>");
			out.print("</form>");
			out.close();
		}
		
		
				
	}


