package com.team2.sbucks.이주희.Order;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import com.team2.sbucks.common.DataSource;



public class OrderDao2 {
	DataSource dataSource;
	//List<OrderDetail> orderDetail;

	public OrderDao2() {
		dataSource = new DataSource();
		//orderDetail = new ArrayList<OrderDetail>();
	}
	
	public int create(Order2 order) throws Exception{
		String insertOrder = "insert into orderlist(order_no,order_date,member_no,order_price) values (orderList_order_no_SEQ.nextval,sysdate,?,?)";
		String insertOrderDetail = "insert into orderdetail(orderdetail_no, order_no, order_stmt, product_no,order_qty,product_espresso,product_syrup) values (ORDERDETAIL_ORDERDETAIL_NO_SEQ.nextval,orderList_order_no_SEQ.currval,1,?,?,?,?)";
		
		Connection con = dataSource.getConnection();
		PreparedStatement pstmt1 = con.prepareStatement(insertOrder);
		PreparedStatement pstmt2 = con.prepareStatement(insertOrderDetail);
		
		pstmt1.setInt(1, order.getMember_no());
		pstmt1.setInt(2, order.getOrder_price());
		
		pstmt1.executeUpdate();
		
		for (OrderDetail orderDetail : order.getOrderDetail()) {
			pstmt2.setInt(1, orderDetail.getProduct().getProduct_no());
			pstmt2.setInt(2, orderDetail.getOrder_qty());
			pstmt2.setInt(3, orderDetail.getProduct_espresso());
			pstmt2.setInt(4, orderDetail.getProduct_syrup());
			pstmt2.executeUpdate();
			
		}
		
		return 0;
	}
	
	
	public int calOrderdetail(OrderDetail orderitem) throws Exception{
		int price=((orderitem.getProduct().getProduct_price())+(orderitem.getProduct_syrup()*orderitem.getProduct().getProduct_syrupprice())+(orderitem.getProduct_espresso()*orderitem.getProduct().getProduct_espressoprice()))*orderitem.getOrder_qty();
		return price;
	}
	
	public int calOrderdetail(List<OrderDetail> orderitem) throws Exception{
		int totalPrice=0;
		for (OrderDetail orderDetail : orderitem) {
			totalPrice+=calOrderdetail(orderDetail);

		}
		return totalPrice;
	}
	
	
	public int deleteOrder() {
		return 0;
	}

	// 주문상태(1,2,3,4) 변경
	public int updateOrder(int orderdetail_no) throws Exception {
		String changeStmt="update orderdetail set order_stmt=order_stmt+1 where orderdetail_no=?";
		Connection con=dataSource.getConnection();
		PreparedStatement pstmt=con.prepareStatement(changeStmt);
		pstmt.setInt(1,orderdetail_no);
		pstmt.executeUpdate();
		return 0;
	}

	// 회원의 주문내역-주문상세 출력 : 주문 1개 
	public Order2 selectOrder(int member_no,int order_no) throws Exception{
		Order2 selectOrder = null;
		String selectSQL = "select * from orderlist o join orderdetail d on o.order_no=d.order_no join product p on d.product_no=p.product_no where member_no=? and o.order_no=?";
		Connection con=dataSource.getConnection();
		PreparedStatement pstmt=con.prepareStatement(selectSQL);
		pstmt.setInt(1, member_no);
		pstmt.setInt(2, order_no);
		ResultSet rs = pstmt.executeQuery();
		if(rs.next()) {
			//nt order_no, Date order_date, int member_no, int order_price, List<OrderDetail> orderDetail
			selectOrder=new Order2(rs.getInt("order_no"), rs.getDate("order_date"),rs.getInt("member_no"), rs.getInt("order_price"));
			
			do {
				selectOrder.getOrderDetail().add(
						//int orderdetail_no, int order_no, int order_qty, int order_stmt, Product product,int product_espresso, int product_syrup
						new OrderDetail(rs.getInt("orderdetail_no"), rs.getInt("order_no"), rs.getInt("order_qty"), rs.getInt("order_stmt"), 
								//int product_no, String product_name, int product_price, String product_allergy,String product_content, int product_espresso, int product_syrup, int product_syrupprice,int product_espressoprice
								new Product(rs.getInt("product_no"), rs.getString("product_name"), rs.getInt("product_price"), rs.getString("product_allergy"), rs.getString("product_content"), 
										rs.getInt("product_espresso"), rs.getInt("product_syrup"), rs.getInt("product_syrupprice"), rs.getInt("product_espressoprice")), rs.getInt("product_espresso"), rs.getInt("product_syrup")));
			}while(rs.next());
					
			
		}
				
		
		return selectOrder;
	}
	//그 회원의 모든 주문내역출력 
	public List<Order2> selectAll(int member_no) throws Exception {
		List<Order2> orderList = new ArrayList<Order2>();
		String selectAll="select * from orderlist where member_no=?";
		Connection con=dataSource.getConnection();
		PreparedStatement pstmt=con.prepareStatement(selectAll);
		pstmt.setInt(1, member_no);
		ResultSet rs=pstmt.executeQuery();
		while(rs.next()) {
			orderList.add(new Order2(rs.getInt("order_no"), rs.getDate("order_date"), rs.getInt("member_no"), rs.getInt("order_price")));
		}
		
		
		
		return orderList;
	}

}
