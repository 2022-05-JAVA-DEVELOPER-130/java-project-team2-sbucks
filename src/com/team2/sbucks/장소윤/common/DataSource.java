package com.team2.sbucks.장소윤.common;

import java.sql.Connection;
import java.sql.DriverManager;

public class DataSource {
	/***********************************************/
	String driverClass = "oracle.jdbc.OracleDriver";
	String url = "jdbc:oracle:thin:@182.237.126.19:1521:xe";
	String user = "jdeveloper51";
	String password = "jdeveloper51";
	/**********************************************/
	
	/*
	 * Connection 객체를 생성해서 반환하는 메쏘드
	 */
	
	public Connection getConnection() throws Exception{
		
		Class.forName(driverClass);
		Connection con = DriverManager.getConnection(url, user, password);
		
		
		
		return con;
	}

}
