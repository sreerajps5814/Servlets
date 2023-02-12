package com.demo.crud.Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.demo.crud.DAO.EmployeeDAO;
import com.demo.crud.DTO.Employee;

@WebServlet("/DeleteServlet")
public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		//out.println("<a href='index.html'>Add new Employee</a>");
		//out.println("<h1>Employee List</h1>");
		String sid=request.getParameter("id");
		int id=Integer.parseInt(sid);
	    Employee e=new Employee();
	    e.setId(id);
	    		int e1=EmployeeDAO.delete(e);
		out.print("Employee deleted");
		request.getRequestDispatcher("ViewServlet").include(request, response);
		out.print("<table border='1' width='100%'>");

		//out.print("<tr><th>ID</th> <th>Name</th> <th>Password</th> <th>Email</th> <th>Country</th> <th>Edit</th> <th>Delete</th></tr>");

		
			//out.print("<tr><td>"+c.getId()+"</td><td>"+c.getName()+"</td><td>"+c.getPwd()+"</td><td>"+c.getEmail()+"</td><td>"+c.getCtry()+"</td><td><a href='EditServlet?id='"+c.getId()+"'>Edit</a></td><td><a href='DeleteServlet?id='"+c.getId()+"'>Delete</a></td></tr>");
			
		
		//out.print("</table>");

		}
	

}
