package com.team2.sbucks.유지훈.sql.order;

public class OrderDetailSQL {
	public static final String ORDERDETAIL_INSERT
	="insert into orderdetail(orderdetail_no, order_no, order_stmt, product_no, order_qty) values(orderdetail_orderdetail_no_seq.nextval, orderlist_order_no_seq.currval, ?, ?, ?)";
	
	
	public static final String ORDERDETAIL_SELECTALL
	="select o.order_no, o.order_date, p.product_name, d.order_qty from orderlist o join orderdetail d on o.order_no = d.order_no join product p on d.product_no = p.product_no where o.order_no = ?";
}
