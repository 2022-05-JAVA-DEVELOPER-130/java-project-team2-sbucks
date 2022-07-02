package com.team2.sbucks.장소윤.service;

import java.util.List;

import com.team2.sbucks.장소윤.dao.LoginDao;
import com.team2.sbucks.장소윤.dao.MemberDao;
import com.team2.sbucks.장소윤.dto.Member;



public class MemberService {

	private MemberDao memberDao; 
	private LoginDao loginDao;
	
	public MemberService() {
		memberDao = new MemberDao();  //객체초기화?
		loginDao = new LoginDao();
	}
	/*
	 * 회원가입
	 */
	
	/*
	 * 아이디가 이미 존재하면 중복되었다는 메세지를 띄운다.
	 */
	/*
	 * 아이디존재여부체크
	 *    - 존재하면 메세지
	 *    - 존재안하면 가입
	 */
	public boolean addMember(Member newMember) throws Exception {
		boolean isSuccess = false;
	
		Member findMember= memberDao.findById(newMember.getMember_id());
		if(findMember ==null) {
			memberDao.insertMember(newMember);
			isSuccess = true;
		}else {
			isSuccess = false;
			System.out.println("이미 존재하는 아이디입니다.");
		}
		return isSuccess;
		}
		
		/*
		 * 비밀번호 확인 
		 */
	
	public boolean checkPassword(String id, String password) throws Exception{
		boolean check = false;
		if(loginDao.selectByID(id).getMember_password().equals(password)) {
			check = true;
			System.out.println("비밀번호가 일치합니다");
			
		}else {
			System.out.println("비밀번호가 일치하지 않습니다.");
			check = false;
		}
			
		return check;
	}
	
	
	
	
	
		/*
		 * 회원가입
		 */
		public int insertMember(Member newMember) throws Exception {
			
			return memberDao.insertMember(newMember);
		}
	
		public Member findById(String member_id) throws Exception{
			
			 	return memberDao.findById(member_id);
		}
		
		/*
		 * 회원정보수정
		 */
		
		public int updateMember(Member updateMember) throws Exception{
			
			return memberDao.updateMember(updateMember);
			
		}
		/* 
		 회원전체검색
		*/
		public List<Member> findAll() throws Exception{
			
			return memberDao.findAll();
		}
		
		
	
		/*
		 * 회원번호로수정
		 */
		
		public int updateByNo(Member updateByNoMember) throws Exception{
			
			return memberDao.updateByNo(updateByNoMember);
		}
		
		/*
		 * 회원번호로삭제
		 */
		public int deleteMember(int member_no)throws Exception{
			
			return memberDao.deleteMember(member_no);
			
		}
		
		/*
		 * 회원정보 출력
		 */
		
		public void printMember(Member findMember) throws Exception{
			Member printMember = memberDao.findById(findMember.getMember_id());
			
			
		}
}
