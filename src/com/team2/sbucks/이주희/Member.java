package com.team2.sbucks.이주희;

import java.text.SimpleDateFormat;
import java.util.Date;

/*
이름              널?       유형           
--------------- -------- ------------ 
MEMBER_NO       NOT NULL NUMBER(10)   
MEMBER_ID       NOT NULL VARCHAR2(50) 
MEMBER_PASSWORD          VARCHAR2(50) 
MEMBER_PHONE             VARCHAR2(50) 
MEMBER_BIRTHDAY          DATE         
MEMBER_EMAIL             VARCHAR2(50) 
MEMBER_NICKNAME          VARCHAR2(50) 
MEMBER_LOC               VARCHAR2(50) 
MEMBER_PAGREE            NUMBER(10)   
MEMBER_EAGREE            NUMBER(10)  
*/

public class Member {
	private int member_no;
	private String member_id;
	private String member_phone;
	private Date memebr_birthday;
	private String member_email;
	private String member_nickname;
	private String member_loc;
	private int member_pagree;
	private int member_eagree;

	public Member() {
		// TODO Auto-generated constructor stub
	}

	public Member(int member_no, String member_id, String member_phone, String sBirthday, String member_email,
			String member_nickname, String member_loc, int member_pagree, int member_eagree) throws Exception {
		super();
		this.member_no = member_no;
		this.member_id = member_id;
		this.member_phone = member_phone;
		SimpleDateFormat sdf = new SimpleDateFormat();
		sdf.applyPattern("yyyy-MM-dd");
		Date birthday = sdf.parse(sBirthday);
		this.memebr_birthday = birthday;
		this.member_email = member_email;
		this.member_nickname = member_nickname;
		this.member_loc = member_loc;
		this.member_pagree = member_pagree;
		this.member_eagree = member_eagree;
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

	public String getMember_phone() {
		return member_phone;
	}

	public void setMember_phone(String member_phone) {
		this.member_phone = member_phone;
	}

	public Date getMemebr_birthday() {
		return memebr_birthday;
	}

	public void setMemebr_birthday(Date memebr_birthday) {
		this.memebr_birthday = memebr_birthday;
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

	public int getMember_pagree() {
		return member_pagree;
	}

	public void setMember_pagree(int member_pagree) {
		this.member_pagree = member_pagree;
	}

	public int getMember_eagree() {
		return member_eagree;
	}

	public void setMember_eagree(int member_eagree) {
		this.member_eagree = member_eagree;
	}

	@Override
	public String toString() {
		return "Member [member_no=" + member_no + ", member_id=" + member_id + ", member_phone=" + member_phone
				+ ", memebr_birthday=" + memebr_birthday + ", member_email=" + member_email + ", member_nickname="
				+ member_nickname + ", member_loc=" + member_loc + ", member_pagree=" + member_pagree
				+ ", member_eagree=" + member_eagree + "]";
	}

}
