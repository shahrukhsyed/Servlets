package com.cg.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import com.cg.bean.Login;
import com.cg.util.DBUtil;

public class LoginDaoImpl implements LoginDao{
	
	Connection con=DBUtil.getConnect();

	@Override
	public Login loginUser(Login user) {
		// TODO Auto-generated method stub
		Login obj=null;
		String qry="select * from UserDetails";
		try {
			Statement stmt=con.createStatement();
			ResultSet rs=stmt.executeQuery(qry);
			while(rs.next()){
				String uname=rs.getString(1);
				String pwd=rs.getString(2);
				if(uname.equals(user.getUsername())&&pwd.equals(user.getPassword())){
					obj=user;
					break;
				}
				
			}
		} 
		catch (Exception e) {
			// TODO Auto-generated catch block
		System.out.println(e.getMessage());	
		}
		return obj;
	
	}
}
