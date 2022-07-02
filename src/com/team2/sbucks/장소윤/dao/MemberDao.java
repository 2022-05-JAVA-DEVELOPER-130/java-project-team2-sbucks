package com.team2.sbucks.장소윤.dao;

import java.sql.Connection;





import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import com.team2.sbucks.common.DataSource;
import com.team2.sbucks.장소윤.dto.Member;

/*
이름              널?       유형           
--------------- -------- ------------ 
MEMBER_NO       NOT NULL NUMBER(10)   
MEMBER_ID       NOT NULL VARCHAR2(50) 
MEMBER_PHONE    NOT NULL VARCHAR2(50) 
MEMBER_BIRTHDAY          DATE         
MEMBER_EMAIL    NOT NULL VARCHAR2(50) 
MEMBER_NICKNAME          VARCHAR2(50) 
MEMBER_LOC               VARCHAR2(50) 
MEMBER_PAGREE            NUMBER(10)   
MEMBER_EAGREE            NUMBER(10)   
  
 */
public class MemberDao {

	private DataSource dataSource;

	public MemberDao() {
		dataSource = new DataSource();
	}

	public int insertMember(Member newMember) throws Exception {

		Connection con = dataSource.getConnection();
		PreparedStatement pstmt = con.prepareStatement(MemberSQL.MEMBER_INSERT);

		pstmt.setString(1, newMember.getMember_id());
		pstmt.setString(2, newMember.getMember_phone());
		java.sql.Date member_date = new java.sql.Date(newMember.getMember_birthday().getTime());
		pstmt.setDate(3, member_date);
		pstmt.setString(4, newMember.getMember_email());
		pstmt.setString(5, newMember.getMemeber_nickname());
		pstmt.setString(6, newMember.getMember_loc());
		pstmt.setInt(7, newMember.getMember_pagree());
		pstmt.setInt(8, newMember.getMember_eagree());

		int insertCount = pstmt.executeUpdate();

		pstmt.close();
		con.close();
		return insertCount;
		/*
		 * java.util.Date utilBirthDay=new SimpleDateFormat("yyyy/MM/dd").parse("1998/05/05");
		Date sqlBirthDay=new Date(utilBirthDay.getTime());
		pstmt.setDate(2,sqlBirthDay);
		 */

		// 질문. java.util.Date utilBirthDay = new
		// SimpleDateFormat("yyyy/MM/dd").parse("");
		// Date sqlBirthDay = new Date(utilBirthDay.getTime());
		// pstmt.setDate(5,sqlBirthDay);

	}
	/*
	public int checkId (String member_id) throws Exception{
		Connection con = dataSource.getConnection();
		PreparedStatement pstmt = con.prepareStatement(MemberSQL.CHECK_ID);
		int idCheck = 0;
		
		pstmt.setString(1, member_id);
		ResultSet rs = pstmt.executeQuery();
		
		
		}
		return 0;
	}
	*/

	public int updateMember(Member updateMember) throws Exception {

		Connection con = dataSource.getConnection();
		PreparedStatement pstmt = con.prepareStatement(MemberSQL.MEMBER_UPDATE);

		pstmt.setString(1, updateMember.getMember_phone());
		pstmt.setString(2, updateMember.getMember_email());
		pstmt.setString(3, updateMember.getMemeber_nickname());
		pstmt.setString(4, updateMember.getMember_loc());
		pstmt.setInt(5, updateMember.getMember_pagree());
		pstmt.setInt(6, updateMember.getMember_eagree());
		pstmt.setString(7, updateMember.getMember_id());

		int updateCount = pstmt.executeUpdate();

		pstmt.close();
		con.close();

		return updateCount;
	}

	public int updateByNo(Member updateByNoMember) throws Exception {

		Connection con = dataSource.getConnection();
		PreparedStatement pstmt = con.prepareStatement(MemberSQL.MEMBER_NO_UPDATE);

		pstmt.setString(1, updateByNoMember.getMember_phone());
		pstmt.setString(2, updateByNoMember.getMember_email());
		pstmt.setString(3, updateByNoMember.getMemeber_nickname());
		pstmt.setString(4, updateByNoMember.getMember_loc());
		pstmt.setInt(5, updateByNoMember.getMember_pagree());
		pstmt.setInt(6, updateByNoMember.getMember_eagree());
		pstmt.setInt(7, updateByNoMember.getMember_no());

		int updateByNoCount = pstmt.executeUpdate();

		pstmt.close();
		con.close();

		return updateByNoCount;
	}

	public int deleteMember(int member_no) throws Exception {

		Connection con = dataSource.getConnection();
		PreparedStatement pstmt = con.prepareStatement(MemberSQL.MEMBER_DELETE);

		pstmt.setInt(1, member_no);

		int deleteCount = pstmt.executeUpdate();

		pstmt.close();
		con.close();

		return deleteCount;
	}

	public Member findById(String member_id) throws Exception {

		Connection con = dataSource.getConnection();
		PreparedStatement pstmt = con.prepareStatement(MemberSQL.MEMBER_FINDBYID);

		Member findMember = null;

		pstmt.setString(1, member_id);
		ResultSet rs = pstmt.executeQuery();

		if (rs.next()) {
			findMember = new Member(rs.getInt("member_no"), rs.getString("member_id"), rs.getString("member_phone"),
					rs.getDate("member_birthday"), rs.getString("member_email"), rs.getString("member_nickname"),
					rs.getString("member_loc"), rs.getInt("member_pagree"), rs.getInt("member_eagree"));
		}
		rs.close();
		pstmt.close();
		con.close();
		return findMember;
	}
	
	
	public Member findEmail(String member_email) throws Exception{
		Connection con = dataSource.getConnection();
		PreparedStatement pstmt = con.prepareStatement(MemberSQL.MEMBER_FINDBYEMAIL);
		Member findMember = null;
		pstmt.setString(1, member_email);
		ResultSet rs = pstmt.executeQuery();
		
		if(rs.next()){
			
			findMember = new Member(rs.getString("member_email"));
			
		}
		rs.close();
		pstmt.close();
		con.close();
		
		
		
		return findMember;
	}
	
	public boolean findPhone(String member_phone) throws Exception{
		Connection con = dataSource.getConnection();
		PreparedStatement pstmt = con.prepareStatement(MemberSQL.MEMBER_FINDPHONE);
		
		pstmt.setString(1, member_phone);
		ResultSet rs = pstmt.executeQuery();
		
		rs.next();
		int rowCount = rs.getInt(1);
		
		if(rowCount==1) {
			return true;
		}else {
			return false;
		}
		
	}
	/*
	 * 이메일, 핸드폰 넣으면 아이디찾기
	 */
	public Member findId(String member_email, String member_phone) throws Exception{
		Connection con = dataSource.getConnection();
		PreparedStatement pstmt = con.prepareStatement(MemberSQL.FIND_ID);
		Member searchId = null;
		
		pstmt.setString(1, member_email);
		pstmt.setString(2, member_phone);
		
		ResultSet rs = pstmt.executeQuery();
		
		if(rs.next()) {
			
			searchId = new Member(rs.getInt("member_no"), rs.getString("member_id"), rs.getString("member_phone"),
					rs.getDate("member_birthday"), rs.getString("member_email"), rs.getString("member_nickname"),
					rs.getString("member_loc"), rs.getInt("member_pagree"), rs.getInt("member_eagree"));
		}

		rs.close();
		pstmt.close();
		con.close();
		return searchId;
	}
	
	
	
	
	
	public List<Member> findAll() throws Exception {

		Connection con = dataSource.getConnection();
		PreparedStatement pstmt = con.prepareStatement(MemberSQL.MEMBER_FINDALL);

		ArrayList<Member> memberList = new ArrayList<Member>(); // 여기 그냥 null로 해도 되는지?

		ResultSet rs = pstmt.executeQuery();

		while (rs.next()) {

			memberList.add(new Member(rs.getInt("member_no"), rs.getString("member_id"), rs.getString("member_phone"),
					rs.getDate("member_birthday"), rs.getString("member_email"), rs.getString("member_nickname"),
					rs.getString("member_loc"), rs.getInt("member_pagree"), rs.getInt("member_eagree")));
		}

		return memberList;
	}
}
