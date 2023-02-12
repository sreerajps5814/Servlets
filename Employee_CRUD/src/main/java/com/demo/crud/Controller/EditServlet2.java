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

@WebServlet("/EditServlet2")
public class EditServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException {
		
		
		PrintWriter out=response.getWriter();
		
		
		String sid=req.getParameter("id");
		int id =Integer.parseInt(sid);
		String name=req.getParameter("name");
		String pwd=req.getParameter("pwd");
		String email=req.getParameter("email");
		String ctry=req.getParameter("ctry");
		
		Employee e1=new Employee();
		e1.setId(id);
		e1.setName(name);
		e1.setPwd(pwd);
		e1.setEmail(email);
		e1.setCtry(ctry);
		
		
		int e=EmployeeDAO.update(e1);
				
		
		if(e>0)
		
 {
		out.print("Employee Updated");
		
}
		 {
			out.print("sorry..");
			out.print("<table border='1' width='100%'>");
			out.print("<tr><th>ID</th> <th>Name</th> <th>Password</th> <th>Email</th> <th>Country</th> <th>Edit</th> <th>Delete</th></tr>");
			
			out.print("</table>");
		}
		

		
		
	}

}
