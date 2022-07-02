package com.team2.sbucks.이주희;


public class MemberDaoTest {
	public static void main(String[] args) throws Exception {
		MemberDao memberDao = new MemberDao();

		Member newMember = new Member(0, "id1", "1111-1121", "2021-12-13", "bbb@email.com", "1번", "서울", 1, 1);
		
		System.out.println("입력 행:" + memberDao.insertMember(newMember));
		
		newMember = new Member(0, "id2", "1111-1111", "2021-12-13", "aaa@email.com", "1번", "서울", 1, 1);
		
		System.out.println("입력 행:" + memberDao.insertMember(newMember));
		
        newMember = new Member(0, "id7", "1111-3333", "2021-12-13", "ccc@email.com", "1번", "서울", 1, 1);
		
		System.out.println("입력 행:" + memberDao.insertMember(newMember));
		
		System.out.println(("삭제 행:" + memberDao.deleteMember(2)));
		
		System.out.println(memberDao.selectByNo(1));
		
		System.out.println(memberDao.selectAll());

	}

}
