package com.team2.sbucks.이주희;

import java.util.Scanner;

import dao.LoginDao;
import dto.Login;

public class LoginTest {
	public static void main(String[] args) throws Exception {
		Scanner scan = new Scanner(System.in);
		LoginDao loginDao = new LoginDao();

		/*
		 * Login newLogin = new Login("id1", "password1", 0); System.out.println("인서트" +
		 * loginDao.insertLogin(newLogin)); newLogin = new Login("id7", "password7", 0);
		 * System.out.println("인서트" + loginDao.insertLogin(newLogin));
		 * 
		 * System.out.println("삭제:"+loginDao.deleteLogin("id1"));
		 * 
		 * Login updateLogin=new Login("id2","변경!",0);
		 * System.out.println("업데이트:"+loginDao.updateLogin(updateLogin));
		 * 
		 * System.out.println(loginDao.selectByID("id2"));
		 */

		System.out.println(loginDao.selectAll());

		System.out.println("---비밀번호 찾기---");
		System.out.println("아이디 입력");
		String memberid = scan.nextLine();
		System.out.println("이메일 입력");
		String memberEmail = scan.nextLine();
		System.out.println(loginDao.findPassword(memberid, memberEmail));
	}

}
