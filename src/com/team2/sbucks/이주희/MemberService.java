package com.team2.sbucks.이주희;





public class MemberService {
	private MemberDao memberDao; 
	private LoginDao loginDao;
	
	public MemberService() {
		memberDao=new MemberDao();
		loginDao=new LoginDao();
	}
	
	//회원가입 -아이디중복확인 /핸드폰중복확인 /이메일중복확
	public int  MemberIn(Member newMember) throws Exception {
		/*if(memberDao.checkID(newMember.getMember_id())==true) {
			System.out.println("id중복");
		}
		else {			
			memberDao.insertMember(newMember);
			System.out.println("가입 완료");
		}*/
		
		if(Checkid(newMember.getMember_id())==false) {
			memberDao.insertMember(newMember);
		}
		
		return 0;
	}
	
	public boolean Checkid(String id) throws Exception{
		boolean check=false;
		
		if(memberDao.checkID(id)==true) {
			check=true;
			System.out.println("중복된 아이디입니다.");
		}else {
			System.out.println("사용가능 아이디입니다.");
		}
		
		
		return check;
	}
	
	public boolean CheckPassword(String id,String password) throws Exception{
		boolean check=false;
		
		//System.out.println(loginDao.selectByID(id));
		if(loginDao.selectByID(id).getMember_password().equals(password)) {
			check=true;
			System.out.println("비밀번호가 일치합니다.");
		}else {
			System.out.println("비밀번호가 일치하지 않습니다.");
		}
		
		return check;
	}
	
	//회원탈퇴
	
	//회원정보출력
	public void printMember(int no) throws Exception{
		String memberID=memberDao.selectByNo(no).getMember_id();
		
		//if(CheckPassword(memberID,))
		System.out.println(memberDao.selectByNo(no));
		//System.out.println(loginDao.selectByID(memberID));
	}
	//회원정보수정 - 
	
	//비밀번호변경
	
	//비밀번호 찾기 
	
	
	//로그인
	
	//로그아웃
	
	

}
