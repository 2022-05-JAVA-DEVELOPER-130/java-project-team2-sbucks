package com.team2.sbucks.이주희;

import java.util.Scanner;



public class MemberServiceTest {
	public static void main(String[] args) throws Exception {
		Scanner scan=new Scanner(System.in);
		MemberService memberService=new MemberService();
		memberService.Checkid("id8");
		
		/*
		Member newMember=new Member(0, "아이디", , null, null, null, null, 0, 0);
		memberService.MemberIn()
		*/
		memberService.printMember(1);
		String memberID="id1";
		int memberNo=1;
		System.out.println("비밀번호를 입력하세요");
	String password=scan.nextLine();
	
	//String password1="password1";
		//memberService.CheckPassword(memberID, password);
		
		if(memberService.CheckPassword(memberID,password)==true) {
			memberService.printMember(memberNo);
		}
	}
	

}
