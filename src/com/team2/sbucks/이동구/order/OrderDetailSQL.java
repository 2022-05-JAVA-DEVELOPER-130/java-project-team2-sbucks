package com.team2.sbucks.이동구.order;



public class OrderDetailSQL {
	public static final String ORDERDETAIL_INSERT
	="insert into orderDetail values(orderDetail_orderDetail_no_seq.nextval,?,?,?,?)";
	public static final String ORDERDETAIL_UPDATE
	="update orderDetail set order_no = ?, order_qty = ?, order_stmt=?, product_no where orederDetail_no = ?";
	public static final String ORDERDETAIL_DELETE
	="delete from orderDetail where orederDetail_no = ?";
	public static final String ORDERDETAIL_SELECT_BY_NO
	="select * from orderDetail where orederDetail_no = ?";
	public static final String ORDERDETAIL_SELECT_ALL
	="select * from orderDetail";
}
