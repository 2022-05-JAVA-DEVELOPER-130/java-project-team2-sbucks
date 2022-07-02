package com.team2.sbucks.이주희;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.team2.sbucks.common.DataSource;



public class MemberDao {

	private DataSource dataSource;

	public MemberDao() {
		dataSource = new DataSource();
	}

	/*public int insertMember(Member newMember) throws Exception {
		Connection con = dataSource.getConnection();
		PreparedStatement pstmt1 = con.prepareStatement(MemberSQL.insertMember);
		PreparedStatement pstmt2 = con.prepareStatement(LoginSQL.insertLogin);
		
		java.sql.Date member_date = new java.sql.Date(newMember.getMemebr_birthday().getTime());
	
		pstmt1.setString(1, newMember.getMember_id());
		pstmt1.setString(2, newMember.getMember_phone());
		pstmt1.setDate(3, member_date);
		pstmt1.setString(4, newMember.getMember_email());
		pstmt1.setString(5, newMember.getMember_nickname());
		pstmt1.setString(6, newMember.getMember_loc());
		pstmt1.setInt(7, newMember.getMember_pagree());
		pstmt1.setInt(8, newMember.getMember_eagree());
		
		
		pstmt2.setString(1, newMember.getMember_id());
			pstmt2.setString(2, login.getMember_password());
			pstmt2.setInt(3, login.getLogin());
		
		pstmt1.executeUpdate();
		
		
		con.close();
		pstmt1.close();
	
		return 0;
	
	}*/

	public int insertMember(Member newMember) throws Exception {
		Connection con = dataSource.getConnection();
		PreparedStatement pstmt1 = con.prepareStatement(MemberSQL.insertMember);

		java.sql.Date member_date = new java.sql.Date(newMember.getMemebr_birthday().getTime());

		pstmt1.setString(1, newMember.getMember_id());
		pstmt1.setString(2, newMember.getMember_phone());
		pstmt1.setDate(3, member_date);
		pstmt1.setString(4, newMember.getMember_email());
		pstmt1.setString(5, newMember.getMember_nickname());
		pstmt1.setString(6, newMember.getMember_loc());
		pstmt1.setInt(7, newMember.getMember_pagree());
		pstmt1.setInt(8, newMember.getMember_eagree());
		int rowCount = pstmt1.executeUpdate();

		con.close();
		pstmt1.close();

		return rowCount;

	}

	public int deleteMember(int memberNo) throws Exception {
		Connection con = dataSource.getConnection();
		PreparedStatement pstmt = con.prepareStatement(MemberSQL.deleteMember);

		pstmt.setInt(1, memberNo);
		int rowCount = pstmt.executeUpdate();

		con.close();
		pstmt.close();
		return rowCount;
	}

	public int updateMember(Member upMember) throws Exception {
		Connection con = dataSource.getConnection();
		PreparedStatement pstmt = con.prepareStatement(MemberSQL.updateMember);

		java.sql.Date guest_date = new java.sql.Date(upMember.getMemebr_birthday().getTime());
		pstmt.setString(1, upMember.getMember_phone());
		pstmt.setDate(2, guest_date);
		pstmt.setString(3, upMember.getMember_email());
		pstmt.setString(4, upMember.getMember_nickname());
		pstmt.setString(5, upMember.getMember_loc());
		pstmt.setInt(6, upMember.getMember_pagree());
		pstmt.setInt(7, upMember.getMember_eagree());
		pstmt.setInt(8, upMember.getMember_no());
		int rowCount = pstmt.executeUpdate();
		con.close();
		pstmt.close();
		return rowCount;
	
	}

	public Member selectByNo(int memberNo) throws Exception {
		Connection con = dataSource.getConnection();
		PreparedStatement pstmt = con.prepareStatement(MemberSQL.selectByNo);
		Member findMember = null;
		pstmt.setInt(1, memberNo);

		ResultSet rs = pstmt.executeQuery();

		if (rs.next()) {

			int member_no = rs.getInt("member_no");
			String member_id = rs.getString("member_id"); // sql date
			String member_phone = rs.getString("member_phone");
			String memebr_birthday = rs.getString("member_birthday");
			String member_email = rs.getString("member_email");
			String member_nickname = rs.getString("member_nickname");
			String member_loc = rs.getString("member_loc");
			int member_pagree = rs.getInt("member_pagree");
			int member_eagree = rs.getInt("member_eagree");

			findMember = new Member(member_no, member_id, member_phone, memebr_birthday, member_email, member_nickname,
					member_loc, member_pagree, member_eagree);
		}

		rs.close();
		pstmt.close();
		con.close();
		return findMember;
	}

	public List<Member> selectAll() throws Exception {
		List<Member> findMemberList = new ArrayList<Member>();

	
		Connection con = dataSource.getConnection();
		PreparedStatement pstmt = con.prepareStatement(MemberSQL.selectAll);
		ResultSet rs = pstmt.executeQuery();

		while (rs.next()) {
			
			findMemberList.add(new Member(rs.getInt("member_no"), rs.getString("member_id"), rs.getString("member_phone"), rs.getString("member_birthday"), rs.getString("member_email"), rs.getString("member_nickname"), rs.getString("member_loc"), rs.getInt("member_pagree") , rs.getInt("member_eagree")));

		}
		rs.close();
		pstmt.close();
		con.close();
		return findMemberList;
		
	}

}
