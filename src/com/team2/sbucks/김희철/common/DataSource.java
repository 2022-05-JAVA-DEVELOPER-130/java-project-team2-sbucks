package com.team2.sbucks.김희철.common;

import java.sql.Connection;
import java.sql.DriverManager;

public class DataSource {
	/**********************************************/
	String driverClass = "oracle.jdbc.OracleDriver";
	String url = "jdbc:oracle:thin:@182.237.126.19:1521:xe";
	String user = "jdeveloper07";
	String password = "jdeveloper07";
	/**********************************************/

	/*
	 * Connection 객체를 생성해서 반환하는 메쏘드(getConnection)
	 */

	public Connection getConncetion() throws Exception { 					// 연결객체를 반환하는 메소드 만들기!
		Class.forName(driverClass); 										// 드라이버 연동
		Connection con = DriverManager.getConnection(url, user, password); 	// 연결객체 만들고 대입연산자.
		return con; 														// 반환
	}
}