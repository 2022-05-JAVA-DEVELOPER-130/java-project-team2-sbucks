package com.team2.sbucks.이동구;

/*
이름         널?       유형         
---------- -------- ---------- 
CART_NO    NOT NULL NUMBER(10) 
PRODUCT_NO          NUMBER(10) 
MEMBER_NO           NUMBER(10) 
CART_QTY            NUMBER(10)
*/

public class Cart {
	private int cart_no;

	private int member_no;
	private int cart_qty;
	private Product product;
	
	
	
	public Cart() {
		// TODO Auto-generated constructor stub
	}
	

	
	
	
	
	

	public Cart(int cart_no, int member_no, Product product,int cart_qty) {
		super();
		this.cart_no = cart_no;
		this.member_no = member_no;
		this.cart_qty = cart_qty;
		this.product = product;
	}








	@Override
	public String toString() {
		return "Cart [cart_no=" + cart_no + ", member_no=" + member_no + ", cart_qty=" + cart_qty + ", product="
				+ product + "]\n";
	}








	public Product getProduct() {
		return product;
	}



	public void setProduct(Product product) {
		this.product = product;
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



	public int getCart_qty() {
		return cart_qty;
	}



	public void setCart_qty(int cart_qty) {
		this.cart_qty = cart_qty;
	}
	
	

}