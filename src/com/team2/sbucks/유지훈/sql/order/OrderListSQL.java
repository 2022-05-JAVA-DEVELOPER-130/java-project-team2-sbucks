package com.team2.sbucks.유지훈.sql.order;

public class OrderListSQL {
	// 회원이 상품을 주문한다.
	public static final String ORDERLIST_INSERT
	="insert into orderlist(order_no, order_date, member_no) values(orderlist_order_no_seq.nextval, sysdate, ?)";
	
	// 회원이 상품이 마음에 안든대요.
	public static final String ORDERLIST_DELETE
	="delete from orderlist where order_no = ?";
	
	//회원 주문 개수 COUNT
	public static final String ORDERLIST_SELECT_BY_COUNT
	="select sum(count(order_no)) from orderlist where member_no = ? group by member_no";
	
}
