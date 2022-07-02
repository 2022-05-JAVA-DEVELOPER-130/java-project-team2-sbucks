package com.team2.sbucks.장소윤.dao;

import java.sql.Connection;


import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.team2.sbucks.common.DataSource;
import com.team2.sbucks.장소윤.dto.Login;
import com.team2.sbucks.장소윤.dto.Member;




/*
 * 이름              널?       유형           
--------------- -------- ------------ 
MEMBER_ID       NOT NULL VARCHAR2(50) 
MEMBER_PASSWORD          VARCHAR2(50) 
LOGIN                    NUMBER(10)   

 */
public class LoginDao {
	private DataSource dataSource;
	
	public LoginDao() {
		dataSource = new DataSource();
	}
	
	
	public int insertLogin (Login newLogin) throws Exception{
		
		Connection con = dataSource.getConnection();
		PreparedStatement pstmt = con.prepareStatement(LoginSQL.LOGIN_INSERT);
		
		pstmt.setString(1, newLogin.getMember_id());
		pstmt.setString(2, newLogin.getMember_password());
		pstmt.setInt(3, newLogin.getLogin());
		
		int insertCount = pstmt.executeUpdate();
		
		pstmt.close();
		con.close();
		
		return insertCount;
	}
	
	public int updatePassword (Login newPassword) throws Exception{
		
		Connection con = dataSource.getConnection();
		PreparedStatement pstmt = con.prepareStatement(LoginSQL.UPDATE_PASSWORD);
		
		pstmt.setString(1, newPassword.getMember_password());
		
		int updateCount = pstmt.executeUpdate();
		
		pstmt.close();
		con.close();
		
		return updateCount;
	}
	
	public Login findPassword (String id, String email) throws Exception{
		Connection con = dataSource.getConnection();
		PreparedStatement pstmt = con.prepareStatement(LoginSQL.FIND_PASSWORD);
		Login findPassword = null;
		
		pstmt.setString(1, id);
		pstmt.setString(2, email);
		
		ResultSet rs = pstmt.executeQuery();
		if(rs.next()) {
			
			findPassword = new Login(rs.getString("member_id"), rs.getString("member_password"),
									rs.getInt("login"));
			
		}
		
		con.close();
		pstmt.close();
		rs.close();
		return findPassword;
	}
	
	
	public Login selectByID (String member_id) throws Exception {
		
		Connection con = dataSource.getConnection();
		PreparedStatement pstmt = con.prepareStatement(LoginSQL.FIND_BY_ID);
		
		Login findLogin = null;
		pstmt.setString(1, member_id);
		ResultSet rs = pstmt.executeQuery();
		
		if(rs.next()) {
			
			findLogin = new Login(rs.getString("member_id"),
									rs.getString("member_password"),
									rs.getInt("login"));
					
		}
		rs.close();
		pstmt.close();
		con.close();

		return findLogin;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
