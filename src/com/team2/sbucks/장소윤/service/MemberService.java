package com.team2.sbucks.장소윤.service;

import java.util.List;

import com.team2.sbucks.장소윤.dao.LoginDao;
import com.team2.sbucks.장소윤.dao.MemberDao;
import com.team2.sbucks.장소윤.dto.Member;

public class MemberService {

	private MemberDao memberDao;
	private LoginDao loginDao;

	public MemberService() {
		memberDao = new MemberDao(); // 객체초기화?
		loginDao = new LoginDao();
	}
	/*
	 * 회원가입
	 */

	/*
	 * 아이디가 이미 존재하면 중복되었다는 메세지를 띄운다.
	 */
	/*
	 * 아이디존재여부체크 - 존재하면 메세지 - 존재안하면 가입
	 */
	public boolean addMember(Member newMember) throws Exception {
		boolean isSuccess = false;

		Member findMember = memberDao.findById(newMember.getMember_id());
		if (findMember == null) {
			// memberDao.insertMember(newMember);
			isSuccess = true;
		} else {
			isSuccess = false;
			System.out.println("이미 존재하는 아이디입니다.");
		}
		return isSuccess;
	}

	/*
	 * 이메일중복체크
	 */
	public boolean duplicateEmail(Member newMember) throws Exception {
		boolean isSuccess = false;
		Member findMember = memberDao.findEmail(newMember.getMember_email());

		if (findMember == null) {
			System.out.println("가능한 이메일입니다.");
			isSuccess = true;
		} else {
			System.out.println("이미 가입되어 있는 이메일입니다.");
			isSuccess = false;
		}
		return isSuccess;
	}

	/*
	 * 핸드폰중복체크
	 */
	public boolean duplicatePhone(String member_phone) throws Exception {
		boolean isSuccess = false;

		if (memberDao.findPhone(member_phone) == true) {
			System.out.println("이미 가입되어 있는 핸드폰번호입니다.");
			isSuccess = false;
		} else {
			System.out.println("가능한 핸드폰번호입니다.");
			isSuccess = true;
		}

		return isSuccess;
	}

	/*
	 * 비밀번호 확인
	 */

	public boolean checkPassword(String id, String password) throws Exception {
		boolean check = false;
		if (loginDao.selectByID(id).getMember_password().equals(password)) {
			check = true;
			System.out.println("비밀번호가 일치합니다");

		} else {
			System.out.println("비밀번호가 일치하지 않습니다.");
			check = false;
		}

		return check;
	}

	/*
	 * 아이디확인
	 */

	public boolean checkID(String id, String password) throws Exception {
		boolean check = false;
		if (loginDao.selectByID(id).getMember_id().equals(id)) {
			check = true;
			System.out.println("아이디가 일치합니다");

		} else {
			System.out.println("아이디가 일치하지 않습니다.");
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

	public Member findById(String member_id) throws Exception {

		return memberDao.findById(member_id);
	}

	/*
	 * 회원정보수정
	 */

	public int updateMember(Member updateMember) throws Exception {

		return memberDao.updateMember(updateMember);

	}

	/*
	 * 회원전체검색
	 */
	public List<Member> findAll() throws Exception {

		return memberDao.findAll();
	}

	/*
	 * 회원번호로수정
	 */

	public int updateByNo(Member updateByNoMember) throws Exception {

		return memberDao.updateByNo(updateByNoMember);
	}

	/*
	 * 회원번호로삭제
	 */
	public int deleteMember(int member_no) throws Exception {

		return memberDao.deleteMember(member_no);

	}

	/*
	 * 회원정보 출력 (회원번호)
	 */

	public void printMember(int member_no) throws Exception {
		String memberID = memberDao.findByNo(member_no).getMember_id();
		System.out.println(memberDao.findByNo(member_no));

	}

	/*
	 * 아이디 비밀번호로 회원정보 찾기
	 */
	public Member findInfo(String member_id, String member_password) throws Exception {
		return memberDao.findInfo(member_id, member_password);
	}

	/*
	 * 이메일, 핸드폰번호로 아이디 찾기
	 */
	public Member findId(String member_email, String member_phone) throws Exception {
		return memberDao.findId(member_email, member_phone);
	}

	/*
	 * 로그인성공
	 */
	public boolean loginSuccess(String member_id, String member_password) throws Exception {
		boolean isSuccess = true;
		if (memberDao.checkID(member_id) == true) {
			if (loginDao.selectByID(member_id).getMember_password().equals(member_password)) {
				System.out.println("로그인성공!");
			} else {
				System.out.println("비밀번호가 틀렸습니다");
				isSuccess = false;
			}
		} else {
			System.out.println("아이디가 틀렸습니다.");
			isSuccess = false;
		}

		return isSuccess;
	}

}
