package com.team2.sbucks.장소윤.test;

import java.util.Date;

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
		
		MemberService memberService = new MemberService();
		
		System.out.println("회원가입");
		Member insertMember = new Member(0, "dfd", "010-3434-df", new Date(), "dfd@naver.com",  "사탕주세요", "서울시 강남구", 0, 0);
		boolean insertOK = memberService.addMember(insertMember);
		System.out.println(insertOK);
		//int deleteCount =memberService.deleteMember(1);
		//System.out.println(">>삭제된 행의 수:"+deleteCount);
	}

}
