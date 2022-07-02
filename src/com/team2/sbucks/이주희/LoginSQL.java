package com.team2.sbucks.이주희;

public class LoginSQL {
	public static final String insertLogin = "insert into login values(?,?,?)";
	public static final String deleteLogin="delete from login where member_id=?";
	public static final String updateLogin="update login set member_id=member_id,member_password=?,login=? where member_id=?";
	public static final String selectById="select * from login where member_id=?";
	public static final String selectAll="select * from login";
	
	public static final String findPassword="select * from login l join membership m on l.member_id =m.member_id where m.member_email=? and l.member_id=?";
}
