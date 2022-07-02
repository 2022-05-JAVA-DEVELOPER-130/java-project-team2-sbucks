package com.team2.sbucks.장소윤.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.team2.sbucks.장소윤.common.DataSource;
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
	
	public int findPassword (Login findPassword) throws Exception{
		Connection con = dataSource.getConnection();
		PreparedStatement pstmt = con.prepareStatement(LoginSQL.FIND_PASSWORD);
		
		pstmt.setString(1, findPassword.getMember_id());
		return 0;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
