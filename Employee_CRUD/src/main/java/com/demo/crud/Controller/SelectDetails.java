package com.demo.crud.Controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.demo.crud.DAO.EmployeeDAO;
import com.demo.crud.DTO.Employee;

public class SelectDetails {
	public static Employee getEmployeeById(int id) {
		Employee e=new Employee();
		try {
			Connection con=EmployeeDAO.getConnection();
			PreparedStatement ps=con.prepareStatement("select * from emp_table where id=?");
			ps.setInt(1, id);
			ResultSet rs=ps.executeQuery();
			if(rs.next())
			{
				e.setId(rs.getInt(1));
				e.setName(rs.getString(2));
				e.setPwd(rs.getString(3));
				e.setEmail(rs.getString(4));
				e.setCtry(rs.getString(5));
			}con.close();
		} catch (Exception e2) {
			
		}
		return e;
		
		
	}

}
