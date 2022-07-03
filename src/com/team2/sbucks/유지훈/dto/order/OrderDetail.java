package com.team2.sbucks.유지훈.dto.order;

import com.team2.sbucks.유지훈.dto.product.Product;

public class OrderDetail {
	private int orderdetail_no;
	private OrderList order_no;
	private int order_qty;
	private int order_stmt;
	private Product product_no;

	
	public OrderDetail() {
		
	}
			
	public OrderDetail(int orderdetail_no, OrderList order_no, int order_qty, int order_stmt, Product product_no) {
		super();
		this.orderdetail_no = orderdetail_no;
		this.order_no = order_no;
		this.order_qty = order_qty;
		this.order_stmt = order_stmt;
		this.product_no = product_no;
	}


	public int getOrderdetail_no() {
		return orderdetail_no;
	}


	public void setOrderdetail_no(int orderdetail_no) {
		this.orderdetail_no = orderdetail_no;
	}


	public OrderList getOrder_no() {
		return order_no;
	}


	public void setOrder_no(OrderList order_no) {
		this.order_no = order_no;
	}


	public int getOrder_qty() {
		return order_qty;
	}


	public void setOrder_qty(int order_qty) {
		this.order_qty = order_qty;
	}


	public int getOrder_stmt() {
		return order_stmt;
	}


	public void setOrder_stmt(int order_stmt) {
		this.order_stmt = order_stmt;
	}


	public Product getProduct_no() {
		return product_no;
	}


	public void setProduct_no(Product product_no) {
		this.product_no = product_no;
	}


	@Override
	public String toString() {
		return "OrderDetail [orderdetail_no=" + orderdetail_no + ", order_no=" + order_no + ", order_qty=" + order_qty
				+ ", order_stmt=" + order_stmt + ", product_no=" + product_no + "]";
	}
	
	
	
}
