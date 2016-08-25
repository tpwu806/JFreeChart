package com.jfreechart.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SqlHelper {

	private Connection con=null;
	private PreparedStatement ps=null;
	private ResultSet rs=null;
	
	private String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
	private String url = "jdbc:sqlserver://127.0.0.1:1499;DatabaseName=VDRMS";
	private String user = "sa";
	private String pwd ="522300";
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public SqlHelper() {		
		try {
			Class.forName(driver);
			con=DriverManager.getConnection(url,user,pwd);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();						
		} catch (SQLException e) {
			e.printStackTrace();
		}		
		
	}
	
	public void close()
	{
		try {
			if(rs!=null) rs.close();
			if(ps!=null) ps.close();
			if(con!=null) con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	 //查询
	public ResultSet queryExecute(String sql,String []params)
	{
		try {
			ps=con.prepareStatement(sql);
			//对sql的参数赋值
			for(int i=0;i<params.length;i++){
				ps.setString(i+1, params[i]);
			}
			//执行查询
			rs=ps.executeQuery();
		} catch (Exception e) {
			e.printStackTrace();			
		}
		//返回结果集
		return rs;
	}

}
