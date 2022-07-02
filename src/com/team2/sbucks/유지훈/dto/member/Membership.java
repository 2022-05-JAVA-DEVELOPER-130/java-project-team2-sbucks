package com.team2.sbucks.유지훈.dto.member;

import java.sql.Date;

public class Membership {
	private int 	member_no;
	private String 	member_id;
	private String	member_password;
	private String	member_phone;
	private Date	member_birthday;
	private String	member_email;
	private String	member_nickname;
	private String	member_loc;
	private	int		member_PAgree;
	private int		member_EAgree;
	
	public Membership() {
		
	}

	public Membership(int member_no, String member_id, String member_password, String member_phone,
			Date member_birthday, String member_email, String member_nickname, String member_loc, int member_PAgree,
			int member_EAgree) {
		super();
		this.member_no = member_no;
		this.member_id = member_id;
		this.member_password = member_password;
		this.member_phone = member_phone;
		this.member_birthday = member_birthday;
		this.member_email = member_email;
		this.member_nickname = member_nickname;
		this.member_loc = member_loc;
		this.member_PAgree = member_PAgree;
		this.member_EAgree = member_EAgree;
	}

	public int getMember_no() {
		return member_no;
	}

	public void setMember_no(int member_no) {
		this.member_no = member_no;
	}

	public String getMember_id() {
		return member_id;
	}

	public void setMember_id(String member_id) {
		this.member_id = member_id;
	}

	public String getMember_password() {
		return member_password;
	}

	public void setMember_password(String member_password) {
		this.member_password = member_password;
	}

	public String getMember_phone() {
		return member_phone;
	}

	public void setMember_phone(String member_phone) {
		this.member_phone = member_phone;
	}

	public Date getMember_birthday() {
		return member_birthday;
	}

	public void setMember_birthday(Date member_birthday) {
		this.member_birthday = member_birthday;
	}

	public String getMember_email() {
		return member_email;
	}

	public void setMember_email(String member_email) {
		this.member_email = member_email;
	}

	public String getMember_nickname() {
		return member_nickname;
	}

	public void setMember_nickname(String member_nickname) {
		this.member_nickname = member_nickname;
	}

	public String getMember_loc() {
		return member_loc;
	}

	public void setMember_loc(String member_loc) {
		this.member_loc = member_loc;
	}

	public int getMember_PAgree() {
		return member_PAgree;
	}

	public void setMember_PAgree(int member_PAgree) {
		this.member_PAgree = member_PAgree;
	}

	public int getMember_EAgree() {
		return member_EAgree;
	}

	public void setMember_EAgree(int member_EAgree) {
		this.member_EAgree = member_EAgree;
	}

	@Override
	public String toString() {
		return "membership [member_no=" + member_no + ", member_id=" + member_id + ", member_password="
				+ member_password + ", member_phone=" + member_phone + ", member_birthday=" + member_birthday
				+ ", member_email=" + member_email + ", member_nickname=" + member_nickname + ", member_loc="
				+ member_loc + ", member_PAgree=" + member_PAgree + ", member_EAgree=" + member_EAgree + "]";
	}
	
	
}
