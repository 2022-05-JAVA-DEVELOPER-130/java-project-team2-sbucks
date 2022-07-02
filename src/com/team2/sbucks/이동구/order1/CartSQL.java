package com.team2.sbucks.ordersql;


	public class CartSQL {
		public static final String CART_INSERT
		="insert into cart(cart_no,product_no,member_no,cart_qty) values(cart_cart_no_seq.nextval,?,?,?)";
		public static final String CART_DELETE
		="delete cart where member_no=?";
		public static final String CART_UPDATE
		="update cart set cart_no=cart_no,product_no=product_no,member_no=member_no,cart_qty=cart_qty+? where member_no=? and product_no=?";
		public static final String CART_SELECT
		="select * from cart c join product p on c.product_no=p.product_no where member_no=? ";
		public static final String CART_CHECK
		="select count(*) from cart where member_no=? and product_no=? ";
	}
