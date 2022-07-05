package com.team2.sbucks.service;

import com.team2.sbucks.dao.member.LoginDao;
import com.team2.sbucks.dao.member.MemberDao;

public class LoginService {
	private LoginDao loginDao;
	private MemberDao memberDao;
	
	public LoginService() {
		loginDao = new LoginDao();
		memberDao = new MemberDao();
	}
	

	
	/*
	 * 비밀번호 확인 후 맞으면 비밀번호 변경
	 */
	public boolean CheckUpdatePassword (String newPassword, String oldPassword) throws Exception{
		boolean isSuccess = false;
		
		if(loginDao.checkPassword(oldPassword)==true) {
			
			loginDao.updatePassword(newPassword, oldPassword);
			isSuccess = true;
			
		}else {
			isSuccess = false;
			System.out.println("비밀번호가 틀렸습니다. 다시 입력해주세요");
		}
		
		return isSuccess;
	}
	
	
}
