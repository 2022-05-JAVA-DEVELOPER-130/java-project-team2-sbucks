package com.team2.sbucks.유지훈.dto.order;

import java.sql.Date;

import com.team2.sbucks.유지훈.dto.member.Membership;

public class OrderList {
	private int  order_no;
	private Date order_date;
	private int  member_no; // member_no만 join 할꺼라 int
	private int  order_price;
	
	public OrderList(int order_no, Date order_date, int member_no, int order_price) {
		super();
		this.order_no = order_no;
		this.order_date = order_date;
		this.member_no = member_no;
		this.order_price = order_price;
	}

	public int getOrder_no() {
		return order_no;
	}

	public void setOrder_no(int order_no) {
		this.order_no = order_no;
	}

	public Date getOrder_date() {
		return order_date;
	}

	public void setOrder_date(Date order_date) {
		this.order_date = order_date;
	}

	public int getMember_no() {
		return member_no;
	}

	public void setMember_no(int member_no) {
		this.member_no = member_no;
	}

	public int getOrder_price() {
		return order_price;
	}

	public void setOrder_price(int order_price) {
		this.order_price = order_price;
	}

	@Override
	public String toString() {
		return "OrderList [order_no=" + order_no + ", order_date=" + order_date + ", member_no=" + member_no
				+ ", order_price=" + order_price + "]";
	}
	
	
	
}
