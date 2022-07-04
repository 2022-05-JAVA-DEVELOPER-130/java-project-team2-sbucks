package com.team2.sbucks.이주희.Order;
/*
 * 이름          널?       유형         
----------- -------- ---------- 
ORDER_NO    NOT NULL NUMBER(10) 
ORDER_DATE           DATE       
MEMBER_NO            NUMBER(10) 
ORDER_PRICE          NUMBER(10) 
 */

public class Order {

	private int order_no;
	private int order_date;
	private int member_no;
	//private int order_price;

	public Order() {
		// TODO Auto-generated constructor stub
	}

	public Order(int order_no, int order_date, int member_no, int order_price) {
		super();
		this.order_no = order_no;
		this.order_date = order_date;
		this.member_no = member_no;
		//this.order_price = order_price;
	}

	public int getOrder_no() {
		return order_no;
	}

	public void setOrder_no(int order_no) {
		this.order_no = order_no;
	}

	public int getOrder_date() {
		return order_date;
	}

	public void setOrder_date(int order_date) {
		this.order_date = order_date;
	}

	public int getMember_no() {
		return member_no;
	}

	public void setMember_no(int member_no) {
		this.member_no = member_no;
	}

	

	@Override
	public String toString() {
		return "Order [order_no=" + order_no + ", order_date=" + order_date + ", member_no=" + member_no
				+ ", order_price=" +  "]";
	}

}
