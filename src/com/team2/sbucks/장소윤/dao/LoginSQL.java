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
	
}
