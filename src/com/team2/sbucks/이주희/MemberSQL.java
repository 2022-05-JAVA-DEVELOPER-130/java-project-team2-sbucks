package com.team2.sbucks.이주희;

/**
 * 
 * @author juhui
 *
 */
public class MemberSQL {
	public static final String insertMember="insert into membership values(membership_member_no_SEQ.nextval,?,?,?,?,?,?,?,?)";
	public static final String deleteMember="delete from membership where member_no=?";
	public static final String updateMember="update membership set member_no=member_no,member_id=member_id,member_phone=?,member_birthday=?,member_email=?,member_nickname=?,member_loc=?,member_pagree=?,member_eagree=? where member_no=?";
	public static final String selectByNo="select * from membership where member_no=?";
	public static final String selectAll="select * from membership";
	
	public static final String CHECK_ID
	="select count(*) from membership where member_id=?";
	
	public static final String CHECK_EMAIL
	="select count(*) from membership where member_email=?";
	
	public static final String CHECK_PHONE
	="select count(*) from membership where member_phone=?";
	
	

}
