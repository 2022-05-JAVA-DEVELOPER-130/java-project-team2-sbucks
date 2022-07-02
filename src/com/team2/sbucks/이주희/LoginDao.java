package com.team2.sbucks.이주희;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.team2.sbucks.common.DataSource;



public class LoginDao {

	DataSource dataSource = new DataSource();

	public LoginDao() {
		dataSource = new DataSource();
	}

	public int insertLogin(Login login) throws Exception {
		Connection con = dataSource.getConnection();
		PreparedStatement pstmt = con.prepareStatement(LoginSQL.insertLogin);

		pstmt.setString(1, login.getMember_id());
		pstmt.setString(2, login.getMember_password());
		pstmt.setInt(3, login.getLogin());

		int rowCount = pstmt.executeUpdate();
		con.close();
		pstmt.close();

		return rowCount;
	}

	public int deleteLogin(String id) throws Exception {
		Connection con = dataSource.getConnection();
		PreparedStatement pstmt = con.prepareStatement(LoginSQL.deleteLogin);

		pstmt.setString(1, id);
		int rowCount = pstmt.executeUpdate();

		con.close();
		pstmt.close();
		return rowCount;

	}

	public int updateLogin(Login login) throws Exception {

		Connection con = dataSource.getConnection();
		PreparedStatement pstmt = con.prepareStatement(LoginSQL.updateLogin);
		pstmt.setString(1, login.getMember_password());
		pstmt.setString(2, login.getMember_id());
		int rowCount = pstmt.executeUpdate();
		con.close();
		pstmt.close();
		return rowCount;
	}

	public Login selectByID(String id) throws Exception {
		Connection con = dataSource.getConnection();
		PreparedStatement pstmt = con.prepareStatement(LoginSQL.selectById);
		Login findLogin = null;
		pstmt.setString(1, id);
		ResultSet rs = pstmt.executeQuery();
		if (rs.next()) {
			findLogin = new Login(rs.getString("member_id"), rs.getString("member_password"), rs.getInt("login"));

		}
		con.close();
		pstmt.close();
		rs.close();
		return findLogin;
	}

	public List<Login> selectAll() throws Exception {
		List<Login> findLoginList = new ArrayList<Login>();
		Connection con = dataSource.getConnection();
		PreparedStatement pstmt = con.prepareStatement(LoginSQL.selectAll);
		ResultSet rs = pstmt.executeQuery();
		while (rs.next()) {
			findLoginList
					.add(new Login(rs.getString("member_id"), rs.getString("member_password"), rs.getInt("login")));
		}
		con.close();
		pstmt.close();
		rs.close();
		return findLoginList;
	}
	
	public Login findPassword(String id,String email) throws Exception{
		Connection con = dataSource.getConnection();
		PreparedStatement pstmt = con.prepareStatement(LoginSQL.findPassword);
		Login findPassword = null;
		
		pstmt.setString(1,email);
		pstmt.setString(2, id);
		
		ResultSet rs=pstmt.executeQuery();
		if(rs.next()) {
			findPassword = new Login(rs.getString("member_id"), rs.getString("member_password"), rs.getInt("login"));

		}
		
		con.close();
		pstmt.close();
		rs.close();
		
		return findPassword;
	}

}
