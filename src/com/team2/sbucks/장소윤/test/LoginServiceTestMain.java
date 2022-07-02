package com.team2.sbucks.장소윤.test;

import java.util.Scanner;

import com.team2.sbucks.장소윤.service.LoginService;

public class LoginServiceTestMain {

	public static void main(String[] args) throws Exception {
		LoginService loginService = new LoginService();
		Scanner scan = new Scanner(System.in);
		
		/*
		 * 비밀번호변경 (비밀번호가 맞는지 확인.맞으면 변경/ 틀리면 다시 입력 메세지출력)
		 */
		boolean updatePasswordOk =loginService.CheckUpdatePassword("7777", "9999");
		System.out.println(updatePasswordOk);

	}

}
