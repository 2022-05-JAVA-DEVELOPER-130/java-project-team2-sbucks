package com.team2.sbucks.장소윤.test;

import java.util.Scanner;


import com.team2.sbucks.장소윤.dao.LoginDao;
import com.team2.sbucks.장소윤.dto.Login;
import com.team2.sbucks.장소윤.service.LoginService;

public class LoginDaoTestMain {

	public static void main(String[] args) throws Exception {
		LoginDao loginDao = new LoginDao();
		LoginService loginService = new LoginService();
		Scanner scan = new Scanner(System.in);
		/*
		System.out.println("---비밀번호 찾기----");
		System.out.println("아이디 입력");
		String member_id = scan.nextLine();
		System.out.println("이메일 입력");
		String member_email = scan.nextLine();
		System.out.println(loginDao.findPassword(member_id, member_email).getMember_password());
		*/
		
		//System.out.println("아이디로 조회");
		//Login searchLogin =loginDao.selectByID("guard1");
		//System.out.println(searchLogin);
		
		//System.out.println("비밀번호 변경");
		//loginDao.updatePassword("8888", "7777");
		
		boolean updatePasswordOk =loginService.CheckUpdatePassword("7777", "9999");
		System.out.println(updatePasswordOk);

	}

}
