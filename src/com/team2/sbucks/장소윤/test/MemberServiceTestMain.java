package com.team2.sbucks.장소윤.test;

import java.util.Date;




import java.util.Scanner;

import com.team2.sbucks.장소윤.dao.MemberDao;
import com.team2.sbucks.장소윤.dto.Member;
import com.team2.sbucks.장소윤.service.MemberService;


/*
 * 이름              널?       유형           
--------------- -------- ------------ 
MEMBER_NO       NOT NULL NUMBER(10)   
MEMBER_ID       NOT NULL VARCHAR2(50) 
MEMBER_PHONE             VARCHAR2(50) 
MEMBER_BIRTHDAY          DATE         
MEMBER_EMAIL             VARCHAR2(50) 
MEMBER_NICKNAME          VARCHAR2(50) 
MEMBER_LOC               VARCHAR2(50) 
MEMBER_PAGREE            NUMBER(10)   
MEMBER_EAGREE            NUMBER(10)   
 */
public class MemberServiceTestMain {

	public static void main(String[] args) throws Exception{
		Scanner scan = new Scanner(System.in);
		MemberService memberService = new MemberService();
		
		//System.out.println("회원가입");
		//Member insertMember = new Member(0, "candy", "010-1111-1111", "2022-05-06", "candy@naver.com",  "사탕주세요", "서울시 강남구", 0, 0);
		//int insertCount = memberService.insertMember(insertMember);
		//System.out.println(insertCount);
		
		
		//boolean insertOK = memberService.addMember(insertMember);
		//System.out.println(insertOK);
		//int deleteCount =memberService.deleteMember(1);
		//System.out.println(">>삭제된 행의 수:"+deleteCount);
		//memberService.updateMember(insertMember);
		//String memberid = scan.nextLine();
		//memberService.findById(memberid);
		
		/*
		System.out.println("----아이디찾기----");
		System.out.println("이메일입력");
		String email = scan.nextLine();
		System.out.println("핸드폰번호입력");
		String phone = scan.nextLine();
		
		System.out.println(memberService.findId(email,phone).getMember_id());
		*/
		
		//Member checkEmail = new Member("guard1@naver.com");
		//boolean checkEmailOk = memberService.duplicateEmail(checkEmail);
		//System.out.println(checkEmailOk);
		
		/*
		 * 둘 중에 어떤 메쏘드가 더 합리적인지 물어보기
		 */
		
		
		//boolean checkPhoneOk = memberService.duplicatePhone("010-6542-0815");
		//System.out.println(checkPhoneOk);
		
		/*
		System.out.println("아이디를 입력하세요");
		String memberID = scan.next();
		System.out.println("비밀번호를 입력하세요");
		String memberPassword = scan.next();
		Member printInfo = memberService.findInfo(memberID, memberPassword);
		System.out.println(printInfo);
		*/
		
		
		
		
		
		/*
		 * 로그인
		 */
		System.out.println("아이디를 입력하세요");
		String memberID = scan.next();
		System.out.println("비밀번호를 입력하세요");
		String memberPassword = scan.next();
		boolean loginCheck = memberService.loginSuccess(memberID, memberPassword);
		System.out.println(loginCheck);
		
		
		}
	}

