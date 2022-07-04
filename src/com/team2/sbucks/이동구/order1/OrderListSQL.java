package com.team2.sbucks.ordersql;

public class OrderListSQL {
	public static final String ORDER_INSERT
	="insert into cart(order_no,order_date,member_no,order_price) values(order_order_no_seq.nextval,?,?,?)";
	public static final String CART_DELETE
	="delete cart where member_no=?";
	public static final String ORDER_PRICE
	="select sum(product_price*cart_qty) from (select p.product_no,p.product_price , c.cart_qty ,c.member_no from product p join cart c on c.product_no=p.product_no) where member_no=3";
	public static final String CART_SELECT
	="select * from cart c join product p on c.product_no=p.product_no where member_no=? ";


}
