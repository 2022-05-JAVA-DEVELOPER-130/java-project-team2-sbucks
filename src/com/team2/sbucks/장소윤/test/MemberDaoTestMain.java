package com.team2.sbucks.장소윤.test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.team2.sbucks.장소윤.dao.MemberDao;
import com.team2.sbucks.장소윤.dto.Member;

public class MemberDaoTestMain {

	public static void main(String[] args) throws Exception{
		 MemberDao memberDao = new MemberDao();
		 
		 //Member findMember = memberDao.findById("guard1");
		 //System.out.println(findMember);
		 
		// Member insertMember =  new Member(0, "candy1", "010-5656-5656", new Date(), "candy1@naver.com",  "무슨사탕", "경기도 안양시", 0, 0);
		 //int insertCount = memberDao.insertMember(insertMember);
		// System.out.println("삽입된 행의 수:"+insertCount);
		 
		 //Member updateMember = new Member(0,"candy1", "010-3587-7898", new Date(),"candy2@naver.com", "청포도사탕", "경기도 시흥시",0,0);
		 //int updateCount = memberDao.updateMember(updateMember);
		 //System.out.println("수정된 행의 수:"+updateCount);
		 
		 //Member updateByNo = new Member(1,"dfd", "010-2323-2323", new Date(), "candy1@naver.com","썬키스트사탕", "경기도 용인시", 1,1);
		 //int updateByNoCount = memberDao.updateByNo(updateByNo);
		 //System.out.println("번호인자받아 수정된 행의 수:"+updateByNoCount);
		 
		 //int deleteCount = memberDao.deleteMember(1);
		 //System.out.println("삭제된 행의 수 :"+deleteCount);
		 
		List<Member> memberList = memberDao.findAll();
		 for (Member member : memberList) {
			 	System.out.println(member);
		}
		 
		 
	}

}
