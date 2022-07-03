package com.team2.sbucks.유지훈.dto.order;

import com.team2.sbucks.유지훈.dto.product.Product;

public class Cart {
	private int cart_no;
	private int member_no; // member 테이블의 no만 써서 int로 했어요.
	private Product product_no; // product 
	private int cart_qty;
	
	public Cart(int cart_no, int member_no, Product product_no, int cart_qty) {
		super();
		this.cart_no = cart_no;
		this.member_no = member_no;
		this.product_no = product_no;
		this.cart_qty = cart_qty;
	}

	public int getCart_no() {
		return cart_no;
	}

	public void setCart_no(int cart_no) {
		this.cart_no = cart_no;
	}

	public int getMember_no() {
		return member_no;
	}

	public void setMember_no(int member_no) {
		this.member_no = member_no;
	}

	public Product getProduct_no() {
		return product_no;
	}

	public void setProduct_no(Product product_no) {
		this.product_no = product_no;
	}

	public int getCart_qty() {
		return cart_qty;
	}

	public void setCart_qty(int cart_qty) {
		this.cart_qty = cart_qty;
	}

	@Override
	public String toString() {
		return "Cart [cart_no=" + cart_no + ", member_no=" + member_no + ", product_no=" + product_no + ", cart_qty="
				+ cart_qty + "]";
	}
	
	
	
	
}
