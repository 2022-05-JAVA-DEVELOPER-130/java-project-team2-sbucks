package com.team2.sbucks.service;

import com.team2.sbucks.dao.member.LoginDao;
import com.team2.sbucks.dao.member.MemberDao;
import com.team2.sbucks.dto.Login;

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
	public boolean CheckUpdatePassword (String newPassword, Login updateMember) throws Exception{
		boolean check = false;
		
		Login findMember = loginDao.selectByID(updateMember.getMember_id());
		if(findMember == null) {
			loginDao.updatePassword(newPassword, updateMember.getMember_password());
			check = true;
		}else {
			check = false;
		}
		
		
	    return check;
	}
	
	public int updatePassword(String newPassword, String oldPassword) throws Exception{
		return loginDao.updatePassword(newPassword, oldPassword);
	}
	
	/*
	 * 회원가입 성공시 로그인 객체에 정보저장
	 */
	public int insertLogin(Login newLogin) throws Exception{
		
		return loginDao.insertLogin(newLogin);
	}
	
	/*
	 * 회원가입 성공시 로그인 상태 업데이트
	 */
	public int updateLogin(Login updateLogin) throws Exception {
		return loginDao.updateLogin(updateLogin);
	}
	
}
