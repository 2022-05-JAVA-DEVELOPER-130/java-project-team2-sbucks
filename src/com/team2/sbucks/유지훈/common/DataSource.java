package com.team2.sbucks.유지훈.common;

import java.sql.Connection;

import java.sql.DriverManager;

public class DataSource {
	/*******************************************************************/
	private String driverClass = "oracle.jdbc.OracleDriver";
	private String url = "jdbc:oracle:thin:@182.237.126.19:1521:xe";
	private String user = "jdeveloper41";
	private String password = "jdeveloper41";
/*******************************************************************/
	public Connection getConnection() throws Exception{ //연결객체를 반환하는 메소드 만들기!
		Class.forName(driverClass); //드라이버 연동
		Connection con = DriverManager.getConnection(url,user,password); // 연결객체 만들고 대입연산자.
		return con; //반환
	}
	
	public String getDriverClass() {
		return driverClass;
	}
	public void setDriverClass(String driverClass) {
		this.driverClass = driverClass;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

}
