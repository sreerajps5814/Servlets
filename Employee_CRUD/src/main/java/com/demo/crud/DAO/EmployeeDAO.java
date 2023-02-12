package com.demo.crud.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.demo.crud.DTO.Employee;

public class EmployeeDAO 
{
	public static Connection getConnection()
	{	Connection con=null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/emp_crud", "root", "admin");
		
	} catch (Exception e) {
		
	}return con;
		
	}
	public static int saveEmployee(Employee emp) 
	{	int status=0;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			//Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/emp_crud", "root", "admin");
			Connection con=EmployeeDAO.getConnection();
			PreparedStatement st=con.prepareStatement("insert into emp_table(name,password,email,country)values(?,?,?,?)");
			System.out.println(st);
			st.setString(1, emp.getName());
			st.setString(2, emp.getPwd());
			st.setString(3, emp.getEmail());
			st.setString(4, emp.getCtry());
			status=st.executeUpdate();
			con.close();
			
		} catch (Exception e) {
			System.out.println(e);
		}
		return status;
			
	}
	
	public static List<Employee> getEmployees() 
	{	
		ArrayList<Employee> l1=new ArrayList<Employee>();
		try {
			Connection con =EmployeeDAO.getConnection();
			PreparedStatement stmt=con.prepareStatement("select * from emp_table");
			ResultSet rs=stmt.executeQuery();
			while(rs.next())
			{
				Employee e1=new Employee();
				e1.setId(rs.getInt(1));
				e1.setName(rs.getString(2));
				e1.setPwd(rs.getString(3));
				e1.setEmail(rs.getString(4));
				e1.setCtry(rs.getString(5));
				l1.add(e1);
			}
	} catch (Exception e) {
		System.out.println(e);
		
	}
		return l1;
		
	}
	
	public static Employee getByID(int id) {
		Employee e=null;
		
		try {
			Connection con =EmployeeDAO.getConnection();
			PreparedStatement stmt=con.prepareStatement("select * from emp_table where id=?");
			stmt.setInt(1, id);
			System.out.println(stmt);
			ResultSet rs=stmt.executeQuery();
			
			while(rs.next())
			{
				e=new Employee();
				e.setId(rs.getInt(1));
				e.setName(rs.getString(2));
				e.setPwd(rs.getString(3));
				e.setEmail(rs.getString(4));
				e.setCtry(rs.getString(5));
				
			}
			
			con.close();
		} catch (Exception e2) 
		{
			e2.printStackTrace();
		}
		return e;
		
	}	
	public static int delete(Employee e) {
		int e1 = 0;
		try {
			Connection con=EmployeeDAO.getConnection();
			PreparedStatement ps=con.prepareStatement("delete from emp_table where id=?");
			ps.setInt(1, e.getId());
			System.out.println(ps);
			e1=ps.executeUpdate();
						
		} catch (Exception e2) {
			System.out.println(e2);
			
		}return e1;
		
	}
	public static int update(Employee e) {
	int  e1 = 0;
		try {
			Connection con=EmployeeDAO.getConnection();
			PreparedStatement stmt=con.prepareStatement("update emp_table name=?,password=?,email=?,country=? where id=?");
			stmt.setString(1, e.getName());
			stmt.setString(2, e.getPwd());
			stmt.setString(3, e.getEmail());
			stmt.setString(4, e.getCtry());
			stmt.setInt(5, e.getId());
			System.out.println(stmt);
			e1=stmt.executeUpdate();
			
				
						
			
			
			System.out.println(e1);
			
			 
		} catch (Exception e2) {
			
		}return e1;
		
	}
	
}
