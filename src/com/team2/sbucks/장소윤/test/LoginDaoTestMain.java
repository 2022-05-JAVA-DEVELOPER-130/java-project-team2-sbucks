package com.team2.sbucks.장소윤.test;

import java.util.Scanner;

import com.team2.sbucks.장소윤.dao.LoginDao;

public class LoginDaoTestMain {

	public static void main(String[] args) throws Exception {
		LoginDao loginDao = new LoginDao();
		Scanner scan = new Scanner(System.in);
		
		System.out.println("---비밀번호 찾기----");
		System.out.println("아이디 입력");
		String member_id = scan.nextLine();
		System.out.println("이메일 입력");
		String member_email = scan.nextLine();
		System.out.println(loginDao.findPassword(member_id, member_email).getMember_password());
		

	}

}
