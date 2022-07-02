package com.team2.sbucks.장소윤.dao;
/*
 * 이름              널?       유형           
--------------- -------- ------------ 
MEMBER_ID       NOT NULL VARCHAR2(50) 
MEMBER_PASSWORD          VARCHAR2(50) 
LOGIN                    NUMBER(10)   

 */
public class LoginSQL {
	public static final String LOGIN_INSERT 
						= "insert into login values (?,?,?)";
	
	public static final String UPDATE_PASSWORD
						= "update login set member_password =? where member_password =?";
	
	public static final String FIND_PASSWORD
						= "select member_password"
								+ " from login l join membership m on l.member_id = m.member_id "
								+ " where m.member_id = ? and m.member_email = ?";
}
