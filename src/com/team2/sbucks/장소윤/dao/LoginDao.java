package com.team2.sbucks.장소윤.dao;

import java.sql.Connection;

import com.team2.sbucks.common.DataSource;
import com.team2.sbucks.dto.Login;


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
		
		
		
		
		return 0;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
